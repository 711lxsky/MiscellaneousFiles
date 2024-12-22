package leetcode_practice

func detectCapitalUse(word string) bool {
	cntH, cntL, n := 0, 0, len(word)
	for i := 0; i < n; i++ {
		if word[i] >= 'A' && word[i] <= 'Z' {
			cntH++
		} else if word[i] >= 'a' && word[i] <= 'z' {
			cntL++
		}
	}
	if cntH == n || cntL == n || (cntH == 1 && word[0] >= 'A' && word[0] <= 'Z') {
		return true
	}
	return false
}
