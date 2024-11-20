package Interview_practice

func decrypt(code []int, k int) []int {
	// 先用最笨的方法，k < 0 就倒序一下，窗口移动的过程中检查一下是否超过边界即可
	n := len(code)
	ans := make([]int, n)
	if k == 0 {
		return ans
	}
	turn := false
	if k < 0 {
		k = -k
		code = reverse(code)
		turn = true
	}
	// 初始求和
	sum := 0
	for i := 0; i < k; i++ {
		sum += code[i]
	}
	for i := 0; i < n; i++ {
		left, right := i, i+k
		if right >= n {
			right -= n
		}
		sum += code[right] - code[left]
		ans[i] = sum
	}
	if turn {
		return reverse(ans)
	}
	return ans
}

func reverse(nums []int) []int {
	for i, j := 0, len(nums)-1; i <= j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
	return nums
}
