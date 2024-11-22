package Interview_practice

func maxFreq(s string, maxLetters int, minSize int, maxSize int) int {
	// 因为实际上最短的字符串能够出现的次数是最多的，所以可以直接忽略掉最大长度，所以可以直接使用集合去重，使用哈希表记录长度
	record := make(map[string]int)
	ans, n := 0, len(s)
	for i := 0; i < n-minSize+1; i++ {
		cur := s[i : i+minSize]
		byteCnt := make(map[byte]int)
		for _, ch := range cur {
			byteCnt[byte(ch)]++
		}
		if len(byteCnt) <= maxLetters {
			record[cur]++
			ans = max(ans, record[cur])
		}
	}
	return ans
}
