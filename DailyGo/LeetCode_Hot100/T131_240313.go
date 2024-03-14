package LeetCode_Hot100

// 回溯 + 预先动规
func partition(s string) (ans [][]string) {
	n := len(s)
	jud := make([][]bool, n)
	for i := range jud {
		// 这里是预先将某个长度的字符串状态初始化
		jud[i] = make([]bool, n)
		for j := range jud[i] {
			jud[i][j] = true
		}
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			// 这里状态转移方程: 当前字符串的两端字符相同再加上内部回文
			jud[i][j] = s[i] == s[j] && jud[i+1][j-1]
		}
	}
	var (
		backtrack func(i int)
		strs      []string
	)
	strs = []string{}
	backtrack = func(i int) {
		if i == n {
			ans = append(ans, append([]string{}, strs...))
		}
		// 从当前位置开始，截取字符串判断回文
		for j := i; j < n; j++ {
			if jud[i][j] {
				strs = append(strs, s[i:j+1])
				backtrack(j + 1)
				strs = strs[:len(strs)-1]
			}

		}
	}
	backtrack(0)
	return
}
