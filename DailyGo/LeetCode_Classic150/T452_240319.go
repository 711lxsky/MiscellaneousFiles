package LeetCode_Classic150

import "sort"

func findMinArrowShots(points [][]int) int {
	if len(points) == 0 {
		return 0
	}
	sort.Slice(points, func(i, j int) bool {
		return points[i][1] < points[j][1]
	})
	maxRight := points[0][1]
	ans := 1
	for _, point := range points {
		if point[0] > maxRight {
			maxRight = point[0]
			ans++
		}
	}
	return ans
}
