package LeetCode_Hot100

func largestRectangleArea(heights []int) int {
	// 单调栈
	heights = append(heights, 0)
	newHeights := []int{0}
	newHeights = append(newHeights, heights...)
	heights = newHeights
	myStack, res, n := []int{0}, 0, len(heights)
	for index := 1; index < n; index++ {
		for heights[index] < heights[myStack[len(myStack)-1]] {
			curHeight := heights[myStack[(len(myStack)-1)]]
			myStack = myStack[:len(myStack)-1]
			curWidth := index - myStack[len(myStack)-1] - 1
			res = MAX(res, curWidth*curHeight)
		}
		myStack = append(myStack, index)
	}
	return res
}

func MAX(a, b int) int {
	if a > b {
		return a
	}
	return b
}
