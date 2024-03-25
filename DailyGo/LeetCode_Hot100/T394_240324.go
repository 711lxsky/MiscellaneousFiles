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
			if len(str) != 0 {
				strStack = append(strStack, string(str))
				str = []byte{}
			}
			num *= 10
			num += int(s[i] - '0')
		} else if s[i] == '[' {
			numStack = append(numStack, num)
			num = 0
		} else if s[i] >= 'a' && s[i] <= 'z' {
			str = append(str, s[i])
		}

		i++
	}
}
