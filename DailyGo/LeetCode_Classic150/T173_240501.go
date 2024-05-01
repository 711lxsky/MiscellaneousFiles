package LeetCode_Classic150

/**
实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：

    BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。
	BST 的根节点 root 会作为构造函数的一部分给出。
	指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
    boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
    int next()将指针向右移动，然后返回指针处的数字。

注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。

你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
*/

// type BSTIterator struct {
// 	record []int
// }
//
// func Constructor(root *TreeNode) (this BSTIterator) {
// 	this.inorder(root)
// 	return
// }
//
// func (this *BSTIterator) inorder(node *TreeNode) {
// 	if node == nil {
// 		return
// 	}
// 	this.inorder(node.Left)
// 	this.record = append(this.record, node.Val)
// 	this.inorder(node.Right)
// }
//
// func (this *BSTIterator) Next() int {
// 	val := this.record[0]
// 	this.record = this.record[1:]
// 	return val
// }
//
// func (this *BSTIterator) HasNext() bool {
// 	return len(this.record) > 0
// }

type BSTIterator struct {
	myStack []*TreeNode
	cur     *TreeNode
}

func Constructor(root *TreeNode) BSTIterator {
	return BSTIterator{cur: root}
}

func (this *BSTIterator) Next() int {
	for node := this.cur; node != nil; node = node.Left {
		this.myStack = append(this.myStack, node)
	}
	this.cur, this.myStack = this.myStack[len(this.myStack)-1], this.myStack[:len(this.myStack)-1]
	val := this.cur.Val
	this.cur = this.cur.Right
	return val
}

func (this *BSTIterator) HasNext() bool {
	return this.cur != nil || len(this.myStack) > 0
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
