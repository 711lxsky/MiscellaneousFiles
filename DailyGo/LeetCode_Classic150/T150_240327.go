package LeetCode_Classic150

import "strconv"

func evalRPN(tokens []string) int {
	var (
		nums []int
	)
	nums = []int{}
	for _, word := range tokens {
		num, err := strconv.Atoi(word)
		if err == nil {
			nums = append(nums, num)
		} else {
			num2 := nums[len(nums)-1]
			nums = nums[:len(nums)-1]
			num1 := nums[len(nums)-1]
			nums = nums[:len(nums)-1]
			res := 0
			if word[0] == '+' {
				res = num1 + num2
			} else if word[0] == '-' {
				res = num1 - num2
			} else if word[0] == '*' {
				res = num1 * num2
			} else if word[0] == '/' {
				res = num1 / num2
			}
			nums = append(nums, res)
		}
	}
	return nums[0]
}
