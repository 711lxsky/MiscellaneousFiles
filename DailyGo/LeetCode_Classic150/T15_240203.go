package LeetCode_Classic150

import "sort"

func threeSum(nums []int) [][]int {
	/* 这个方法实际上是暴力+优化
	* 首先排序，将nums变成一个有序数组，然后第一层固定左端，中右同时移动
	 */
	n, ans := len(nums), make([][]int, 0)
	sort.Ints(nums)
	// 第一层
	for left := 0; left < n; left++ {
		// 因为有序，所以直接将重复的去除
		if left > 0 && nums[left] == nums[left-1] {
			continue
		}
		right, mid := n-1, left+1
		// 第二层
		for tar := -nums[left]; mid < right; mid++ {
			if mid > left+1 && nums[mid] == nums[mid-1] {
				continue
			}
			// 第三层
			for right > mid && nums[right]+nums[mid] > tar {
				right--
			}
			if mid == right {
				break
			}
			if nums[right]+nums[mid] == tar {
				ans = append(ans, []int{nums[left], nums[mid], nums[right]})
			}
		}
	}
	return ans
}
