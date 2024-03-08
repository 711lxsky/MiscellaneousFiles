package LeetCode_Classic150

// 使用哈希表
func isHappy(n int) bool {
	var (
		record map[int]bool
		get    func(num int) int
	)
	record = map[int]bool{}
	get = func(num int) int {
		sum := 0
		for num > 0 {
			sum += (num % 10) * (num % 10)
			num /= 10
		}
		return sum
	}
	for ; n != 1 && !record[n]; n, record[n] = get(n), true {

	}
	return n == 1
}
