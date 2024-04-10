package LeetCode_Hot100

import (
	"container/heap"
	"sort"
)

type sortInts struct {
	sort.IntSlice
}

type MedianFinder struct {
	minNums, maxNums sortInts
}

func Constructor295() MedianFinder {
	return MedianFinder{}
}

func (this *MedianFinder) AddNum(num int) {
	minQue, maxQue := &this.minNums, &this.maxNums
	if minQue.Len() == 0 || num <= -minQue.IntSlice[0] {
		heap.Push(minQue, -num)
		if maxQue.Len()+1 < minQue.Len() {
			heap.Push(maxQue, -heap.Pop(minQue).(int))
		}
	} else {
		heap.Push(maxQue, num)
		if maxQue.Len() > minQue.Len() {
			heap.Push(minQue, -heap.Pop(maxQue).(int))
		}
	}
}

func (this *MedianFinder) FindMedian() float64 {
	if this.minNums.Len() > this.maxNums.Len() {
		return float64(-this.minNums.IntSlice[0])
	}
	return float64(-this.minNums.IntSlice[0]+this.maxNums.IntSlice[0]) / 2
}

func (si *sortInts) Push(v interface{}) {
	si.IntSlice = append(si.IntSlice, v.(int))
}

func (si *sortInts) Pop() interface{} {
	tmp1 := si.IntSlice
	value := tmp1[len(tmp1)-1]
	si.IntSlice = tmp1[:len(tmp1)-1]
	return value

}
