package leetcode_practice

func maximumsSplicedArray(nums1 []int, nums2 []int) int {
	return max(calculate(nums1, nums2), calculate(nums2, nums1))
}

func calculate(nums1, nums2 []int) int {
	sumDiff, sum, res := 0, 0, 0
	for i, _ := range nums1 {
		sumDiff += max(sumDiff, 0) + nums1[i] - nums2[i]
		res = max(res, sumDiff)
		sum += nums1[i]
	}
	return res + sum
}
