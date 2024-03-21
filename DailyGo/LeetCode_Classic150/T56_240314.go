package LeetCode_Classic150

import "sort"

func merge(intervals [][]int) (ans [][]int) {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	prev, n := intervals[0], len(intervals)
	for i := 1; i < n; i++ {
		cur := intervals[i]
		if prev[1] < cur[0] { // 没有重叠区间
			ans = append(ans, prev)
			prev = cur
		} else {
			prev[1] = getNumMax(prev[1], cur[1])
		}
	}
	ans = append(ans, prev)
	return
}

func getNumMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}
