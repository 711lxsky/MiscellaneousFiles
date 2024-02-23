package LeetCode_Classic150

// 复制原二维数组，在此基础上进行统计
func gameOfLife1(board [][]int) {
	rowNum, columnNum := len(board), len(board[0])
	//var copyBoard [][]int
	//for i := 0; i < rowNum; i++ {
	//	var copyColumn []int
	//	for j := 0; j < columnNum; j++ {
	//		copyColumn = append(copyColumn, board[i][j])
	//	}
	//	copyBoard = append(copyBoard, copyColumn)
	//}
	// 二维数组复制
	copyBoard := make([][]int, rowNum)
	for index := range board {
		copyBoard[index] = make([]int, columnNum)
		copy(copyBoard[index], board[index])
	}

	neighbor := []int{-1, 0, 1}
	for i := 0; i < rowNum; i++ {
		for j := 0; j < columnNum; j++ {
			// 对邻居进行查看
			neighborLiveNum := 0
			for dirRow := 0; dirRow < 3; dirRow++ {
				for dirCol := 0; dirCol < 3; dirCol++ {
					if neighbor[dirRow] != 0 || neighbor[dirCol] != 0 {
						nRowIndex, nColIndex := i+neighbor[dirRow], j+neighbor[dirCol]
						if nRowIndex >= 0 && nRowIndex < rowNum && nColIndex >= 0 && nColIndex < columnNum && copyBoard[nRowIndex][nColIndex] == 1 {
							neighborLiveNum++
						}
					}
				}
			}
			// 死亡规则
			if neighborLiveNum < 2 || neighborLiveNum > 3 {
				board[i][j] = 0
			}
			if neighborLiveNum == 3 || (board[i][j] == 1 && columnNum == 2) {
				board[i][j] = 1
			}
		}
	}
}

// 使用额外状态记录周围细胞状态
func gameOfLife(board [][]int) {
	rowNum, colNum := len(board), len(board[0])
	neighbor := []int{-1, 0, 1}
	for i := 0; i < rowNum; i++ {
		for j := 0; j < colNum; j++ {
			// 查看邻居
			neighborLiveNum := 0
			for dirRow := 0; dirRow < 3; dirRow++ {
				for dirCol := 0; dirCol < 3; dirCol++ {
					if neighbor[dirRow] != 0 || neighbor[dirCol] != 0 {
						nr, nc := i+neighbor[dirRow], j+neighbor[dirCol]
						if nr >= 0 && nr < rowNum && nc >= 0 && nc < colNum && getABS(board[nr][nc]) == 1 {
							neighborLiveNum += 1
						}
					}
				}
			}
			// 活细胞死亡 ： 1 -> -1
			if (board[i][j] == 1) && (neighborLiveNum < 2 || neighborLiveNum > 3) {
				board[i][j] = -1
			}
			// 死细胞复活 ： 0 -> 2
			if board[i][j] == 0 && neighborLiveNum == 3 {
				board[i][j] = 2
			}
		}
	}
	// 将状态回归0/1
	for i := 0; i < rowNum; i++ {
		for j := 0; j < colNum; j++ {
			if board[i][j] > 0 {
				board[i][j] = 1
			} else {
				board[i][j] = 0
			}
		}
	}
}

func getABS(num int) int {
	if num < 0 {
		return -1 * num
	}
	return num
}
