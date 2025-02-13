package leetcode_practice

type ListNode struct {
	Val  int
	Next *ListNode
}

func sortList(head *ListNode) *ListNode {
	return halfMerge(head, nil)
}

func halfMerge(head *ListNode, tail *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	if head.Next == tail {
		head.Next = nil
		return head
	}
	slow, fast := head, head
	for fast != tail {
		fast = fast.Next
		slow = slow.Next
		if fast != tail {
			fast = fast.Next
		}
	}
	return merge(halfMerge(head, slow), halfMerge(slow, tail))
}

func merge(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{-1, nil}
	ptr := dummy
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			ptr.Next = l1
			l1 = l1.Next
		} else {
			ptr.Next = l2
			l2 = l2.Next
		}
		ptr = ptr.Next
	}
	if l1 != nil {
		ptr.Next = l1
	}
	if l2 != nil {
		ptr.Next = l2
	}
	return dummy.Next
}
