package LeetCode_Hot100

import "strings"

var (
	src string
	ptr int
)

func decodeString(s string) string {
	src, ptr = s, 0
	return getStr()
}

func getStr() string {
	if ptr == len(src) || src[ptr] == ']' {
		return ""
	}
	cur, repeat, res := src[ptr], 1, ""
	if cur >= '0' && cur <= '9' {
		repeat = getTime()
		ptr++
		str := getStr()
		ptr++
		res = strings.Repeat(str, repeat)
	} else if cur >= 'a' && cur <= 'z' {
		res = string(cur)
		ptr++
	}
	return res + getStr()
}

func getTime() int {
	time := 0
	for src[ptr] >= '0' && src[ptr] <= '9' {
		time = time*10 + int(src[ptr]-'0')
		ptr++
	}
	return time
}
