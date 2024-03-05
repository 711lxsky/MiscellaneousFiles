package LeetCode_Hot100

// 多源广度优先遍历
func orangesRotting(grid [][]int) int {
	freshNum, step := 0, 0
	var orangeStack [][]int // 记录腐烂橘子位置
	rowNum, colNum := len(grid), len(grid[0])
	for i := 0; i < rowNum; i++ {
		for j := 0; j < colNum; j++ {
			if grid[i][j] == 1 {
				freshNum++
			} else if grid[i][j] == 2 {
				orangeStack = append(orangeStack, []int{i, j})
			}
		}
	}
	dirRow, dirCol := []int{-1, 1, 0, 0}, []int{0, 0, -1, 1} // 附近方位
	for freshNum > 0 && len(orangeStack) > 0 {
		step++
		rotOrangeNum := len(orangeStack)
		for i := 0; i < rotOrangeNum; i++ {
			curRotRowIndex, curRotColIndex := orangeStack[0][0], orangeStack[0][1]
			orangeStack = orangeStack[1:len(orangeStack)] // 当前最前腐烂橘子出栈
			for j := 0; j < 4; j++ {
				nextRotRowIndex, nextRotColIndex := curRotRowIndex+dirRow[j], curRotColIndex+dirCol[j]
				if nextRotRowIndex < 0 || nextRotRowIndex >= rowNum || nextRotColIndex < 0 || nextRotColIndex >= colNum {
					continue
				}
				if grid[nextRotRowIndex][nextRotColIndex] == 1 {
					freshNum--
					grid[nextRotRowIndex][nextRotColIndex] = 2
					orangeStack = append(orangeStack, []int{nextRotRowIndex, nextRotColIndex})
				}
			}
		}
	}
	if freshNum > 0 {
		return -1
	}
	return step
}
