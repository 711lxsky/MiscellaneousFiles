package LeetCode_Classic150

var m, n int

func solve1(board [][]byte) {
	m, n = len(board), len(board[0])
	for i := 0; i < m; i++ {
		dfs(board, i, 0)
		dfs(board, i, n-1)
	}
	for j := 1; j < n-1; j++ {
		dfs(board, 0, j)
		dfs(board, m-1, j)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'Z' {
				board[i][j] = 'O'
			} else if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
		}
	}
}

func dfs(board [][]byte, x, y int) {
	if x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O' {
		return
	}
	board[x][y] = 'Z'
	dfs(board, x-1, y)
	dfs(board, x+1, y)
	dfs(board, x, y-1)
	dfs(board, x, y+1)
}

var (
	// 全局方向变量
	dir = [][]int{
		{0, 1},
		{0, -1},
		{1, 0},
		{-1, 0},
	}
	myQue [][]int
)

// 广度优先
func solve(board [][]byte) {
	m, n := len(board), len(board[0])
	if m == 0 || n == 0 {
		return
	}
	myQue = [][]int{}
	for i := 0; i < m; i++ {
		// 第一列
		if board[i][0] == 'O' {
			myQue = append(myQue, []int{i, 0})
			board[i][0] = 'Z'
		}
		if board[i][n-1] == 'O' {
			myQue = append(myQue, []int{i, n - 1})
			board[i][n-1] = 'Z'
		}
	}
	for j := 1; j < n-1; j++ {
		if board[0][j] == 'O' {
			myQue = append(myQue, []int{0, j})
			board[0][j] = 'Z'
		}
		if board[m-1][j] == 'O' {
			myQue = append(myQue, []int{m - 1, j})
			board[m-1][j] = 'Z'
		}
	}
	// 以周边的 O 为起点， 向内里扩散
	for len(myQue) > 0 {
		cur := myQue[0]
		myQue = myQue[1:]
		for i := 0; i < 4; i++ {
			x, y := cur[0]+dir[i][0], cur[1]+dir[i][1]
			if x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O' {
				continue
			}
			myQue = append(myQue, []int{x, y})
			board[x][y] = 'Z'
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'Z' {
				board[i][j] = 'O'
			} else if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
		}
	}
}
