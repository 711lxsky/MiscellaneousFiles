package leetcode_practice

import "math"

func findRestaurant(list1 []string, list2 []string) (ans []string) {
	// 先记录 l1 的索引
	record := map[string]int{}
	for i, s := range list1 {
		record[s] = i
	}
	// 再去遍历 l2 同时更新索引和
	indexSum := math.MaxInt32
	for i, s := range list2 {
		if i > indexSum {
			return
		}
		if j, ok := record[s]; ok {
			if i+j < indexSum {
				indexSum = i + j
				ans = []string{s}
			} else if i+j == indexSum {
				ans = append(ans, s)
			}
		}
	}
	return
}
