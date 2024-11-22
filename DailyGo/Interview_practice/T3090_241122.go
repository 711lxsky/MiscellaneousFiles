package Interview_practice

func maximumLengthSubstring(s string) int {
	n, record := len(s), map[byte]int{}
	left, right, ans := 0, 0, 0
	for right < n {
		if time, ok := record[s[right]]; ok {
			if time == 2 {
				for left < right {
					record[s[left]]--
					left++
					if s[left-1] == s[right] {
						break
					}
				}
			}
		}
		record[s[right]]++
		right++
		ans = max(ans, right-left)
	}
	return ans
}
