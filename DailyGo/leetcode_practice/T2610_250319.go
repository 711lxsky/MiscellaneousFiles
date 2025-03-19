package leetcode_practice

func findMatrix(nums []int) [][]int {
	record := map[int]int{}
	for _, num := range nums {
		record[num]++
	}
	res := [][]int{}
	for len(record) > 0 {
		cur := []int{}
		for num, time := range record {
			cur = append(cur, num)
			time--
			if time == 0 {
				delete(record, num)
			} else {
				record[num] = time
			}
		}
		res = append(res, cur)
	}
	return res
}
