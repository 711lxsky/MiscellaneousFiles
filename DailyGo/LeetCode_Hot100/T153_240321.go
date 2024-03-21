package LeetCode_Hot100

import "math"

func findMin(nums []int) int {
	// 左右寻找小值
	left, right := 0, len(nums)-1
	minNum := math.MaxInt
	for left <= right {
		mid := left + (right-left)/2
		if nums[left] <= nums[mid] { // 左侧有序
			minNum = getNumMin(minNum, nums[left]) // 和左侧最小值比较
			left = mid + 1                         // 再去右侧寻找
		} else { // 反之，右侧有序
			minNum = getNumMin(minNum, nums[mid]) // 中值必定是小于右侧数的
			right = mid - 1
		}
	}
	return minNum
}

func getNumMin(a, b int) int {
	if a < b {
		return a
	}
	return b
}
