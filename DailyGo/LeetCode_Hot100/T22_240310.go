package LeetCode_Hot100

// dfs
func generateParenthesis1(n int) (ans []string) {
	var (
		backtrack func(leftNum int)
		curStr    string
	)
	resLen := n * 2
	curStr = ""
	backtrack = func(leftNum int) {
		lenStr := len(curStr)
		if lenStr == resLen {
			ans = append(ans, curStr)
		}
		if leftNum < n {
			curStr += "("
			backtrack(leftNum + 1)
			curStr = curStr[:len(curStr)-1]
		}
		if lenStr-leftNum < leftNum {
			curStr += ")"
			backtrack(leftNum)
			curStr = curStr[:len(curStr)-1]
		}
	}
	backtrack(0)
	return
}

// 暴力检查
// 思路是手动生成一串由 ( ) 组成的字符串， 然后去检验是否符合括号匹配规则
// 大概生成的种类有 2^n种
func generateParenthesis(n int) (ans []string) {
	var (
		selfGenerateAndCheck func()
		check                func(string) bool
	)
	lenTar := n * 2
	//brackets := []byte{'(', ')'}
	curStr := string(lenTar)
	selfGenerateAndCheck = func() {
		lenCurStr := len(curStr)
		if lenTar == lenCurStr && check(curStr) {
			ans = append(ans, curStr)
		}
		curStr += "("
		selfGenerateAndCheck()
		curStr = curStr[:lenCurStr-1]
		curStr += ")"
		selfGenerateAndCheck()
	}
	check = func(str string) bool {
		cnt := 0
		for _, ch := range str {
			if ch == '(' {
				cnt++
			} else {
				cnt--
			}
			if cnt < 0 {
				return false
			}
		}
		return true
	}
	selfGenerateAndCheck()
	return
}
