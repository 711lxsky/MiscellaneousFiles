package interview.year25.huawei0409.t1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        Map<String, List<String>> dependencyMap = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, Integer> iterationCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] parts = in.nextLine().split(" ");
            String currentVersion = parts[0];
            String previousVersion = parts[1];
            iterationCount.put(currentVersion, 0);
            if ("NA".equals(previousVersion)) {
                continue; 
            }
            dependencyMap.putIfAbsent(previousVersion, new ArrayList<>());
            dependencyMap.get(previousVersion).add(currentVersion);
            inDegree.put(currentVersion, inDegree.getOrDefault(currentVersion, 0) + 1);
        }
        Queue<String> queue = new LinkedList<>();
        for (String version : iterationCount.keySet()) {
            if (!inDegree.containsKey(version)) {
                queue.offer(version);
            }
        }
        int maxIteration = 0;
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String version = queue.poll();
            int count = iterationCount.get(version);
            if (count > maxIteration) {
                maxIteration = count;
                result.clear();
                result.add(version);
            } else if (count == maxIteration) {
                result.add(version);
            }
            if (dependencyMap.containsKey(version)) {
                for (String nextVersion : dependencyMap.get(version)) {
                    iterationCount.put(nextVersion, Math.max(iterationCount.get(nextVersion), count + 1));
                    // 减少入度
                    inDegree.put(nextVersion, inDegree.get(nextVersion) - 1);
                    if (inDegree.get(nextVersion) == 0) {
                        queue.offer(nextVersion);
                    }
                }
            }
        }
        Collections.sort(result);
        System.out.println(String.join(" ", result));
    }
}