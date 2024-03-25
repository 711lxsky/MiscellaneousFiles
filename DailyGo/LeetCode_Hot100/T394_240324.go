package LeetCode_Hot100

func decodeString(s string) string {
	var (
		numStack []int
		strStack []string
		str      []byte
	)
	numStack = []int{}
	strStack = []string{}
	str = []byte{}
	i, n := 0, len(s)
	num := 0
	for i < n {
		if s[i] >= '0' && s[i] <= '9' {
			num *= 10
			num += int(s[i] - '0')
		} else if s[i] >= 'a' && s[i] <= 'z' {
			str = append(str, s[i])
		} else if s[i] == '[' {
			numStack = append(numStack, num)
			num = 0
			strStack = append(strStack, string(str))
			str = []byte{}
		} else { // 这时候只有]
			tmp := []byte{}
			repeatTime := numStack[len(numStack)-1]
			// 没有除掉重复次数
			numStack = numStack[:len(numStack)-1]
			for j := 0; j < repeatTime; j++ {
				tmp = append(tmp, str...)
			}
			str = append([]byte(strStack[len(strStack)-1]), tmp...)
			strStack = strStack[:len(strStack)-1]
		}
		i++
	}
	return string(str)
}
