package leetcode_practice

func sortArrayByParityII(nums []int) []int {
	// 直接定义两个下标，分别是偶数和奇数
	i, j, n := 0, 1, len(nums)
	for i < n {
		if nums[i]%2 == 1 {
			for nums[j]%2 == 1 {
				j += 2
			}
			nums[i], nums[j] = nums[j], nums[i]
		}
		i += 2
	}
	return nums
}
