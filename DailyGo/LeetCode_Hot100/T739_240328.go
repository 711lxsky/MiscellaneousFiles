package LeetCode_Hot100

// 单调栈
func dailyTemperatures(temperatures []int) []int {
	n, myStack := len(temperatures), []int{}
	ans := make([]int, n)
	for index, temperature := range temperatures {
		for len(myStack) > 0 && temperature > temperatures[myStack[len(myStack)-1]] {
			preIndex := myStack[len(myStack)-1]
			ans[preIndex] = index - preIndex
			myStack = myStack[:len(myStack)-1]
		}
		myStack = append(myStack, index)
	}
	return ans
}
