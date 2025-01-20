package leetcode_practice

func findClosestNumber(nums []int) int {
	res := nums[0]
	for _, num := range nums {
		if abs(num) < abs(res) || (abs(num) == abs(res) && num > res) {
			res = num
		}
	}
	return res
}
