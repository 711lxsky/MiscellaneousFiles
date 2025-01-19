package leetcode_practice

func largestGoodInteger(num string) string {
	n := len(num)
	if n < 3 {
		return ""
	}

	res := ""
	for i := 2; i < n; i++ {
		if num[i] == num[i-1] && num[i] == num[i-2] {
			candidate := num[i-2 : i+1]
			if res == "" || candidate > res {
				res = candidate
			}
		}
	}
	return res
}
