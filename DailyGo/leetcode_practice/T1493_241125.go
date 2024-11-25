package leetcode_practice

func longestSubarray1(nums []int) int {
	// 先尝试结尾数组和起始数组
	n, res := len(nums), 0
	pre, suf := make([]int, n), make([]int, n)
	pre[0] = nums[0]
	for i := 1; i < n; i++ {
		if nums[i] == 0 {
			pre[i] = 0
		} else {
			pre[i] = pre[i-1] + 1
		}
	}
	suf[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		if nums[i] == 0 {
			suf[i] = 0
		} else {
			suf[i] = suf[i+1] + 1
		}
	}
	for i := 0; i < n; i++ {
		p, s := 0, 0
		if i != 0 {
			p = pre[i-1]
		}
		if i != n-1 {
			s = suf[i+1]
		}
		res = max(res, p+s)
	}
	return res
}

func longestSubarray(nums []int) int {
	// 优化
	n, res := len(nums), 0
	p0, p1 := 0, 0
	for i := 0; i < n; i++ {
		if nums[i] == 0 {
			p1 = p0
			p0 = 0
		} else {
			p1++
			p0++
		}
		res = max(res, p1)
	}
	if res == n {
		res--
	}
	return res
}
