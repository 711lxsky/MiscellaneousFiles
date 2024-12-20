package leetcode_practice

func findComplement(num int) int {
	// 拿到最高位1的位置
	high := 0
	for i := 1; i < 31; i++ {
		if num < 1<<i {
			break
		}
		high = i
	}
	return num ^ (1<<(high+1) - 1)
}
