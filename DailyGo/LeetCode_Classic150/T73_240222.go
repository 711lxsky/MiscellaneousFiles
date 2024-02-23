package LeetCode_Classic150

func setZeroes(matrix [][]int) {
	// 使用第一行进行记录
	firstRow, m, n := false, len(matrix), len(matrix[0])
	for j := 0; j < n; j++ {
		if matrix[0][j] == 0 {
			firstRow = true
		}
	}
	for rowIndex, rowNums := range matrix {
		for columnIndex, num := range rowNums {
			if num == 0 && rowIndex != 0 {
				matrix[rowIndex][0] = 0
				matrix[0][columnIndex] = 0
			}
		}
	}
	for i := m - 1; i > 0; i-- {
		for j := n - 1; j > 0; j-- {
			if matrix[i][0] == 0 || matrix[0][j] == 0 {
				matrix[i][j] = 0
			}
		}
	}
	if firstRow {
		for j := 0; j < n; j++ {
			matrix[0][j] = 0
		}
	}
}
