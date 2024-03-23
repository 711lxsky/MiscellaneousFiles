package LeetCode_Classic150

import "strings"

func simplifyPath(path string) string {
	dirs := strings.Split(path, "/")
	var myStack []string
	myStack = []string{}
	for _, dir := range dirs {
		if dir == ".." {
			if len(myStack) != 0 {
				myStack = myStack[:len(myStack)-1]
			}
		} else if dir != "" && dir != "." {
			myStack = append(myStack, dir)
		}
	}
	return "/" + strings.Join(myStack, "/")
}
