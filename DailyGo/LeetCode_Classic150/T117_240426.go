package LeetCode_Classic150

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}
	nodeRecord := []*Node{root}
	for len(nodeRecord) > 0 {
		curSize := len(nodeRecord)
		for i := 0; i < curSize; i++ {
			curNode := nodeRecord[0]
			nodeRecord = nodeRecord[1:]
			if i < curSize-1 {
				curNode.Next = nodeRecord[0]
			} else {
				curNode.Next = nil
			}
			if curNode.Left != nil {
				nodeRecord = append(nodeRecord, curNode.Left)
			}
			if curNode.Right != nil {
				nodeRecord = append(nodeRecord, curNode.Right)
			}
		}
	}
	return root
}
