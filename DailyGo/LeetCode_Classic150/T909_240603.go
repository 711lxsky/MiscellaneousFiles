package LeetCode_Classic150

func snakesAndLadders(board [][]int) int {
	n := len(board)
	visit := make([]bool, n*n+1)
	type pair struct {
		id, step int
	}
	myQue := []pair{{1, 0}}
	// 一直到队列为空(说明无法到达)， 或者在循环内到达终点返回
	for len(myQue) > 0 {
		cur := myQue[0]
		myQue = myQue[1:]
		// 六面骰子
		for i := 1; i <= 6; i++ {
			next := cur.id + i
			if next > n*n {
				break
			}
			nextRow, nextCol := parseId2Pos(next, n)
			if board[nextRow][nextCol] > 0 {
				next = board[nextRow][nextCol]
			}
			if next == n*n {
				return cur.step + 1
			}
			if !visit[next] {
				visit[next] = true
				myQue = append(myQue, pair{next, cur.step + 1})
			}
		}
	}
	return -1
}

// 根据id计算位置
func parseId2Pos(id, n int) (row, col int) {
	row, col = (id-1)/n, (id-1)%n
	if row%2 == 1 {
		col = n - 1 - col
	}
	// 行号转换为矩阵逆序
	row = n - 1 - row
	return
}
