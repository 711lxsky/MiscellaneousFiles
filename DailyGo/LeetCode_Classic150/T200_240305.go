package LeetCode_Classic150

import "strings"

// 直接上哈希表
func wordPattern(pattern string, s string) bool {
	words := strings.Split(s, " ")
	lenP, lenW := len(pattern), len(words)
	if lenP != lenW {
		return false
	}
	recordP, recordW := map[byte]string{}, map[string]byte{}
	for i := 0; i < lenP; i++ {
		if recordP[pattern[i]] != "" && recordP[pattern[i]] != words[i] || recordW[words[i]] > 0 && recordW[words[i]] != pattern[i] {
			return false
		}
		recordP[pattern[i]] = words[i]
		recordW[words[i]] = pattern[i]
	}
	return true
}
