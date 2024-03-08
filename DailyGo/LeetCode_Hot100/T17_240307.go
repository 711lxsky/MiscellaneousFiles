package LeetCode_Hot100

// 直接递归回溯
var phone map[string]string = map[string]string{
	"2": "abc",
	"3": "def",
	"4": "ghi",
	"5": "jkl",
	"6": "mno",
	"7": "pqrs",
	"8": "tuv",
	"9": "wxyz",
}

var combinations []string

func letterCombinations1(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	combinations = []string{}
	backtrack(digits, 0, "")
	return combinations
}

func backtrack(digits string, index int, combination string) {
	// 字符全进了
	if index == len(digits) {
		combinations = append(combinations, combination)
	} else {
		digit := string(digits[index])
		letters := phone[digit]
		lettersLen := len(letters)
		for i := 0; i < lettersLen; i++ {
			backtrack(digits, index+1, combination+string(letters[i]))
		}
	}
}

// 使用队列迭代求解
func letterCombinations(digits string) []string {
	lenDigits := len(digits)
	if lenDigits == 0 {
		return []string{}
	}
	letterPhone := []string{
		" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
	}
	ans := []string{""}
	for i := 0; i < lenDigits; i++ {
		letters := letterPhone[digits[i]-'0']
		curSize := len(ans)
		for j := 0; j < curSize; j++ {
			curStr := ans[0]
			ans = ans[1:len(ans)]
			for _, ch := range letters {
				ans = append(ans, curStr+string(ch))
			}
		}
	}
	return ans
}
