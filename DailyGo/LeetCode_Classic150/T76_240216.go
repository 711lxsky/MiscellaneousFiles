package LeetCode_Classic150

import "math"

func minWindow(s string, t string) string {
	// 只需要一个map
	lenS, lenT := len(s), len(t)
	if lenS == 0 || lenT == 0 {
		return ""
	}
	left, right, needCnt, minLen := 0, 0, lenT, math.MaxInt
	record, ansPtr := map[byte]int{}, -1
	for i := 0; i < lenT; i++ {
		record[t[i]]++
	}
	for right < lenS {
		rightChar := t[right]
		if record[rightChar] > 0 {
			needCnt--
		}
		record[rightChar]--
		if needCnt == 0 {
			for left < right && record[t[left]] < 0 {
				record[t[left]]++
				left++
			}
			if right-left+1 < minLen {
				minLen = right - left + 1
				ansPtr = left
			}
			record[t[left]]++
			left++
			needCnt++
		}
		right++
	}
	if ansPtr == -1 {
		return ""
	}
	return s[ansPtr : ansPtr+minLen]
}
