package Interview_practice

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	slow, fast := head, head.Next
	for slow != fast {
		if fast != nil && fast.Next != nil {
			slow = slow.Next
			fast = fast.Next.Next
		} else {
			return false
		}
	}
	return true
}
