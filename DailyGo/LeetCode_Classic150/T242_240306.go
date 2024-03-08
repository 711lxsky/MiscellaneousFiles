package LeetCode_Classic150

func isAnagram(s string, t string) bool {
	lenS, lenT := len(s), len(t)
	if lenS != lenT {
		return false
	}
	cnt := make([]int, 26)
	for i := 0; i < lenS; i++ {
		cnt[s[i]-'a']++
	}
	for j := 0; j < lenT; j++ {
		cnt[t[j]-'a']--
		if cnt[t[j]-'a'] < 0 {
			return false
		}
	}
	return true
}
