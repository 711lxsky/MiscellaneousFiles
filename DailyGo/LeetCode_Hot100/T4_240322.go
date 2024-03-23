package LeetCode_Hot100

import "math"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// 使得 nums1 的长度要更小
	len1, len2 := len(nums1), len(nums2)
	if len1 > len2 {
		return findMedianSortedArrays(nums2, nums1)
	}
	left, right := 0, len1
	midNum1, midNum2 := 0, 0
	for left <= right {
		// 分割
		inter1 := left + (right-left)/2
		inter2 := len1 + (len2-len1+1)/2 - inter1
		// 拿到分割线左右两侧的值
		num1Left := math.MinInt32
		if inter1 != 0 {
			num1Left = nums1[inter1-1]
		}
		num1Right := math.MaxInt32
		if inter1 != len1 {
			num1Right = nums1[inter1]
		}
		num2Left := math.MinInt32
		if inter2 != 0 {
			num2Left = nums2[inter2-1]
		}
		num2Right := math.MaxInt32
		if inter2 != len2 {
			num2Right = nums2[inter2]
		}
		if num1Left <= num2Right {
			midNum1 = judMax(num1Left, num2Left)
			midNum2 = judMin(num1Right, num2Right)
			left = inter1 + 1
		} else {
			right = inter1 - 1
		}
	}
	if (len1+len2)%2 == 0 {
		return float64(midNum1+midNum2) / 2.0
	}
	return float64(midNum1)
}

func judMin(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func judMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}
