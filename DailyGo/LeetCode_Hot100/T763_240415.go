package LeetCode_Hot100

func partitionLabels(s string) (ans []int) {
	record := make([]int, 26)
	for index, letter := range s {
		record[getIndexForLetter(letter)] = index
	}
	start, end := 0, 0
	for index, letter := range s {
		end = Max(end, record[getIndexForLetter(letter)])
		if index == end {
			ans = append(ans, end-start+1)
			start = end + 1
		}
	}
	return
}

func getIndexForLetter(b int32) int {
	return int(b - 'a')
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
