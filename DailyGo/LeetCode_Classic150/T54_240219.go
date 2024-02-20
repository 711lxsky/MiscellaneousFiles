package LeetCode_Classic150

func spiralOrder(matrix [][]int) []int {
	rowNums, columns := len(matrix), len(matrix[0])
	if rowNums == 0 || columns == 0 {
		return []int{}
	}
	var (
		ans                      = make([]int, rowNums*columns)
		index                    = 0
		left, right, top, bottom = 0, columns - 1, 0, rowNums - 1
	)
	for left <= right && top <= bottom {
		for colIndex := left; colIndex <= right; colIndex++ {
			ans[index] = matrix[top][colIndex]
			index++
		}
		for rowIndex := top + 1; rowIndex <= bottom; rowIndex++ {
			ans[index] = matrix[rowIndex][right]
			index++
		}
		if left < right && top < bottom {
			for colIndex := right - 1; colIndex > left; colIndex-- {
				ans[index] = matrix[bottom][colIndex]
				index++
			}
			for rowIndex := bottom; rowIndex > top; rowIndex-- {
				ans[index] = matrix[rowIndex][left]
				index++
			}
		}
		left++
		right--
		top++
		bottom--
	}
	return ans
}
