package leetcode_practice

import (
	"sort"
	"strconv"
)

func findRelativeRanks(score []int) []string {
	record := map[int]string{}
	tmp := make([]int, len(score))
	for i, v := range score {
		tmp[i] = v
	}
	sort.Sort(sort.Reverse(sort.IntSlice(tmp)))
	for i, num := range tmp {
		if i == 0 {
			record[num] = "Gold Medal"
		} else if i == 1 {
			record[num] = "Silver Medal"
		} else if i == 2 {
			record[num] = "Bronze Medal"
		} else {
			record[num] = strconv.Itoa(i + 1)
		}
	}
	ans := make([]string, len(score))
	for i, num := range score {
		ans[i] = record[num]
	}
	return ans
}
