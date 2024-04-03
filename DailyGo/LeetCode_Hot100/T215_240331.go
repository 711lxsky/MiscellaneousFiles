package LeetCode_Hot100

import "container/heap"

type HeapInt []int

func (h HeapInt) Len() int {
	return len(h)
}

func (h HeapInt) Less(i, j int) bool {
	return h[i] > h[j]
}

func (h HeapInt) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *HeapInt) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *HeapInt) Pop() any {
	tempH := *h
	n := len(tempH)
	x := tempH[n-1]
	*h = tempH[:n-1]
	return x
}

func findKthLargest1(nums []int, k int) int {
	myBigHeap := &HeapInt{}
	heap.Init(myBigHeap)
	for _, num := range nums {
		heap.Push(myBigHeap, num)
	}
	for i := 0; i < k-1; i++ {
		heap.Pop(myBigHeap)
	}
	return heap.Pop(myBigHeap).(int)
}

// 快排实现
func findKthLargest2(nums []int, k int) int {
	n := len(nums)
	return quick(nums, 0, n-1, n-k)
}

func quick(nums []int, l, r, k int) int {
	if l == r {
		return nums[k]
	}
	partition := nums[l]
	i := l - 1
	j := r + 1
	for i < j {
		for i++; nums[i] < partition; i++ {
		}
		for j--; nums[j] > partition; j-- {
		}
		if i < j {
			nums[i], nums[j] = nums[j], nums[i]
		}
	}
	if k <= j {
		return quick(nums, l, j, k)
	} else {
		return quick(nums, j+1, r, k)
	}
}

// 堆排
func findKthLargest(nums []int, k int) int {
	heapSize := len(nums)
	buildHeap(nums, heapSize)
	for i := len(nums) - 1; i >= len(nums)-k+1; i-- {
		nums[0], nums[i] = nums[i], nums[0]
		heapSize--
		maxHeapify(nums, 0, heapSize)
	}
	return nums[0]
}

func buildHeap(nums []int, heapSize int) {
	for i := heapSize / 2; i >= 0; i-- {
		maxHeapify(nums, i, heapSize)
	}
}

func maxHeapify(nums []int, index, heapSize int) {
	largest, left, right := index, index*2+1, index*2+2
	if left < heapSize && nums[left] > nums[largest] {
		largest = left
	}
	if right < heapSize && nums[right] > nums[largest] {
		largest = right
	}
	if largest != index {
		nums[largest], nums[index] = nums[index], nums[largest]
		maxHeapify(nums, largest, heapSize)
	}
}
