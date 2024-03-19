package LeetCode_Hot100

func searchMatrix(matrix [][]int, target int) bool {
	m, n := len(matrix), len(matrix[0])
	for i := 0; i < m; i++ {
		if target <= matrix[i][n-1] {
			curNums := matrix[i]
			for left, right := 0, n-1; left <= right; {
				mid := left + (right-left)/2
				if curNums[mid] == target {
					return true
				} else if curNums[mid] > target {
					right = mid - 1
				} else {
					uy7
					left = mid + 1
				}
			}
			return false
		}
	}
	return false
}
