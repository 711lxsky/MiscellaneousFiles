package LeetCode_Hot100

func longestValidParentheses1(s string) int {
	n := len(s)
	dp, maxLen := make([]int, n), 0
	dp[0] = 0
	for i := 1; i < n; i++ {
		if s[i] == ')' {
			if s[i-1] == '(' {
				if i >= 2 {
					dp[i] = dp[i-2] + 2
				} else {
					dp[i] = 2
				}
			} else if i-dp[i-1] > 0 && s[i-dp[i-1]-1] == '(' {
				if i-dp[i-1] >= 2 {
					dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
				} else {
					dp[i] = dp[i-1] + 2
				}
			}
			maxLen = getMax(maxLen, dp[i])
		}
	}
	return maxLen
}

func longestValidParentheses(s string) int {
	myStack, maxLen := []int{-1}, 0
	for index, ch := range s {
		if ch == '(' {
			myStack = append(myStack, index)
		} else {
			myStack = myStack[:len(myStack)-1]
			if len(myStack) == 0 {
				myStack = append(myStack, index)
			} else {
				maxLen = getMax(maxLen, index-myStack[len(myStack)-1])
			}
		}
	}
	return maxLen
}
