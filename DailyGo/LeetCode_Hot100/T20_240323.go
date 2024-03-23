package LeetCode_Hot100

func isValid(s string) bool {
	var myStack []byte
	myStack = []byte{}
	for index := range s {
		if s[index] == '(' || s[index] == '[' || s[index] == '{' {
			myStack = append(myStack, s[index])
		} else {
			if len(myStack) == 0 {
				return false
			}
			if s[index] == ')' && myStack[len(myStack)-1] != '(' {
				return false
			}
			if s[index] == ']' && myStack[len(myStack)-1] != '[' {
				return false
			}
			if s[index] == '}' && myStack[len(myStack)-1] != '{' {
				return false
			}
			myStack = myStack[:len(myStack)-1]
		}
	}
	return len(myStack) == 0
}
