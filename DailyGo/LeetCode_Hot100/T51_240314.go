package LeetCode_Hot100

// 回溯 + 集合存储棋盘状态

var (
	ans    [][]string
	N      int
	cols   map[int]bool
	bias1  map[int]bool
	bias2  map[int]bool
	queens []int
)

func solveNQueens(n int) [][]string {
	ans, N, queens = [][]string{}, n, make([]int, n)
	for i := range queens {
		queens[i] = -1
	}
	cols, bias1, bias2 = map[int]bool{}, map[int]bool{}, map[int]bool{}
	try(0)
	return ans
}

func try(rowIndex int) {
	if rowIndex == N {
		ans = append(ans, generateBoard())
		return
	}
	for i := 0; i < N; i++ {
		if cols[i] {
			continue
		}
		bia1 := rowIndex - i
		if bias1[bia1] {
			continue
		}
		bia2 := rowIndex + i
		if bias2[bia2] {
			continue
		}
		queens[rowIndex] = i
		cols[i], bias1[bia1], bias2[bia2] = true, true, true
		try(rowIndex + 1)
		queens[rowIndex] = -1
		delete(cols, i)
		delete(bias1, bia1)
		delete(bias2, bia2)
	}
	return
}

func generateBoard() []string {
	curBord := make([]string, 0)
	for i := 0; i < N; i++ {
		rowBord := make([]byte, N)
		for j := 0; j < N; j++ {
			rowBord[j] = '.'
		}
		rowBord[queens[i]] = 'Q'
		curBord = append(curBord, string(rowBord))
	}
	return curBord
}
