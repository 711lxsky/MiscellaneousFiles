package LeetCode_Classic150

func lengthOfLongestSubstring(s string) int {
	// 使用哈希表，键值对关系是 字母-位置下标,  再用双指针进行移动
	n := len(s)
	record := map[byte]int{}
	left, right, res := 0, 0, 0
	for right < n {
		if curAlIndex, ok := record[s[right]]; ok {
			left = curAlIndex

		}
		record[s[right]] = right + 1
		right++
		res = getMax(res, right-left)
	}
	return res
}

func getMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}
