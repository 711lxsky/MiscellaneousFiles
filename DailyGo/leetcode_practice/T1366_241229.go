package leetcode_practice

import "sort"

func rankTeams(votes []string) string {
	// 大致思路还是先使用Hash表或者使用数组进行票数的记录，然后构建一个pair结构来进行排序等操作
	record, n := make(map[byte]int), len(votes[0])
	for _, vote := range votes {
		for i := 0; i < n; i++ {
			record[vote[i]] += n - i + 1
		}
	}
	type pair struct {
		target byte
		score  int
	}
	pairs := make([]pair, 0, len(record))
	for target, score := range record {
		pairs = append(pairs, pair{target, score})
	}
	sort.Slice(pairs, func(i, j int) bool {
		if pairs[i].score == pairs[j].score {
			return pairs[i].target < pairs[j].target
		}
		return pairs[i].score > pairs[j].score
	})
	res := ""
	for _, p := range pairs {
		res += string(p.target)
	}
	return res
}
