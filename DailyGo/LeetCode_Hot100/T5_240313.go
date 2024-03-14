package LeetCode_Hot100

// 动态规划
func longestPalindrome(s string) string {
	n := len(s)
	jud := make([][]bool, n)
	for i := range jud {
		jud[i] = make([]bool, n)
		for j := range jud[i] {
			jud[i][j] = true
		}
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			jud[i][j] = s[i] == s[j] && jud[i+1][j-1]
		}
	}
	maxLen, ansStr := -1, ""
	for i := 0; i < n; i++ {
		for j := i; j < n; j++ {
			if jud[i][j] && j-i > maxLen {
				maxLen = j - i
				ansStr = s[i : j+1]
			}
		}
	}
	return ansStr
}
