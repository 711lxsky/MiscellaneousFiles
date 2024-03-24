package LeetCode_Hot100

import "math"

type MinStack struct {
	numStack []int
	minStack []int
}

func Constructor() MinStack {
	return MinStack{
		numStack: []int{},
		minStack: []int{math.MaxInt64},
	}
}

func (this *MinStack) Push(val int) {
	this.numStack = append(this.numStack, val)
	topMin := this.minStack[len(this.minStack)-1]
	this.minStack = append(this.minStack, getMin(topMin, val))
}

func (this *MinStack) Pop() {
	this.numStack = this.numStack[:len(this.numStack)-1]
	this.minStack = this.minStack[:len(this.minStack)-1]
}

func (this *MinStack) Top() int {
	return this.numStack[len(this.numStack)-1]
}

func (this *MinStack) GetMin() int {
	return this.minStack[len(this.minStack)-1]
}

func getMin(a, b int) int {
	if a < b {
		return a
	}
	return b
}
