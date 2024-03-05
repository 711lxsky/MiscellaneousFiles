package LeetCode_Hot100

func canFinish1(numCourses int, prerequisites [][]int) bool {
	// 深度优先
	var (
		matrix = make([][]int, numCourses)
		visit  = make([]int, numCourses)
		ans    = true
		dfs    func(u int)
	)

	dfs = func(u int) {
		visit[u] = 1
		for _, v := range matrix[u] {
			if visit[v] == 0 {
				dfs(v)
				if !ans {
					return
				}
			} else if visit[v] == 1 {
				ans = false
				return
			}
		}
		visit[u] = 2
	}

	for _, course := range prerequisites {
		matrix[course[1]] = append(matrix[course[1]], course[0])
	}

	for i := 0; i < numCourses && ans; i++ {
		if visit[i] == 0 {
			dfs(i)
		}
	}
	return ans
}

func canFinish(numCourse int, prerequisites [][]int) bool {
	// 广度优先
	var (
		edges     = make([][]int, numCourse)
		inDegrees = make([]int, numCourse)
		cnt       = 0
	)
	for _, course := range prerequisites {
		edges[course[1]] = append(edges[course[1]], course[0])
		inDegrees[course[0]]++
	}
	var myQue []int
	for index, inDegree := range inDegrees {
		if inDegree == 0 {
			myQue = append(myQue, index)
			cnt++
		}
	}
	for len(myQue) != 0 {
		curCourse := myQue[0]
		myQue = myQue[1:len(myQue)]
		for _, tarCourse := range edges[curCourse] {
			inDegrees[tarCourse]--
			if inDegrees[tarCourse] == 0 {
				myQue = append(myQue, tarCourse)
				cnt++
			}
		}
	}
	return cnt == numCourse
}
