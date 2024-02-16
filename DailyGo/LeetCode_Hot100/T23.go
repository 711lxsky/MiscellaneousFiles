package LeetCode_Hot100

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeKLists(lists []*ListNode) *ListNode {
	// 朴素解法，可以逐个合并，相当于2个有序链表的合并进行k次
	var res *ListNode
	for _, l := range lists {
		res = mergeTwoList(res, l)
	}
	return res
}

func mergeTwoList(ptr1, ptr2 *ListNode) *ListNode {
	dummy := &ListNode{Next: nil}
	ptr := dummy
	for ptr1 != nil && ptr2 != nil {
		if ptr1.Val < ptr2.Val {
			ptr.Next = ptr1
			ptr1 = ptr1.Next
		} else {
			ptr.Next = ptr2
			ptr2 = ptr2.Next
		}
		ptr = ptr.Next
	}
	if ptr1 != nil {
		ptr.Next = ptr1
	} else if ptr2 != nil {
		ptr.Next = ptr2
	}
	return dummy.Next
}
