package leetcode_practice

func maxAbsoluteSum1(nums []int) int {
	// 拆成两部分，一个是最大的子数组和，一个是最小的字数组和
	res, maxSum, minSum := 0, 0, 0
	for _, num := range nums {
		maxSum = max(maxSum+num, num)
		minSum = min(minSum+num, num)
		res = max(res, maxSum, -minSum)
	}
	return res
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func maxAbsoluteSum(nums []int) int {
	// 这里用前缀和的方式也能写
	maxS, minS := 0, 0
	sum := 0
	for _, num := range nums {
		sum += num
		if sum > maxS {
			maxS = sum
		} else if sum < minS {
			minS = sum
		}
	}
	return maxS - minS
}
