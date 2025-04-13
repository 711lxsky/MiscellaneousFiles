package interview.year25.huawei0409.t2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] startEnd = scanner.nextLine().split(" ");
        String start = startEnd[0];
        String end = startEnd[1];
        Map<String, List<Edge>> graph = new HashMap<>();
        while (true) {
            String line = scanner.nextLine();
            if ("0000".equals(line)) break;
            String[] parts = line.split(" ");
            String u = parts[0];
            String v = parts[1];
            int time = Integer.parseInt(parts[2]);

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, time));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, time));
        }
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> prev = new HashMap<>(); // 前驱节点
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (String station : graph.keySet()) {
            distance.put(station, Integer.MAX_VALUE);
        }
        distance.put(start, 0);
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            String u = current.station;
            if (u.equals(end)) break;
            for (Edge neighbor : graph.getOrDefault(u, Collections.emptyList())) {
                String v = neighbor.station;
                int alt = distance.get(u) + neighbor.time;
                if (alt < distance.get(v)) {
                    distance.put(v, alt);
                    prev.put(v, u);
                    pq.add(new Edge(v, alt));
                }
            }
        }
        List<String> path = new ArrayList<>();
        String curr = end;
        while (curr != null) {
            path.add(0, curr);
            curr = prev.get(curr);
        }
        System.out.println(String.join(" ", path));
    }

    static class Edge {
        String station;
        int time;

        public Edge(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}