/*  大致思路应该是两个堆， 
其中大根堆存放相对小的值, 小根堆放稍大值，
算中位数时，直接去堆顶元素即可
加入元素时，先考虑大根堆(小值)
*/
type MedianFinder struct {
	smallNums []int
	largeNums []int
}


func Constructor() MedianFinder {
	medianFinder := MedianFinder{
		smallNums : make([]int, 0)
		largeNums : make([]int, 0)
	}
	return MedianFinder
}


func (this *MedianFinder) AddNum(num int)  {
	if len(this.smallNums) == 0 {
		this.smallNums = append(this.smallNums, num)
	}else {
		if num <= smallNums[0] {
		// 小于等于小值的堆顶， 直接进小值大根堆
		if len(this.smallNums) > len(this.largeNums) {
			// 小值堆数量过多，需要平衡调整
			num0 := this.smallest[0]
			this.smallest = this.smallest[1 : len(this.smallNums)]
			this.largeNums = append(this.largeNums, num0)
			this.thisSmallHeapify
		}
		this.smallNums = append(this.smallNums, num)
		this.thisLargeHeapify;
		}else {
			// 否则，进大值小根堆
			if len(this.largeNums) == len(this.smallNums) {
				// 数量过多，调整
				num0 := this.largeNums[0]
				this.largeNums = this.largeNums[1 : len(this.largeNums)]
				this.smallNums = append(this.smallNums, num0)
				this.thisLargeHeapify
			}
			this.largeNums = append(this.largeNums, num)
			this.thisSmallHeapify
		}
	}
}


func (this *MedianFinder) FindMedian() float64 {
	if len(this.smallNums) > len(this.largeNums) {
		return (float64)(this.smallNums[0])
	}else {
		return float64((this.smallNums[0] +this.largeNums[0]) / 2)
	}
}

func (this *MedianFinder) thisSmallHeapify(){
	smallHeapify(this.largeNums, 0, len(largeNums))
}

// 大值小根堆调整
func smallHeapify(nums []int, index, heapSize int){
	smallest, nextLeft, nextRight := index, index * 2 +1, index * 2 + 2
	if nextLeft < heapSize && nums[nextLeft] < nums[smallest] {
		smallest = nextLeft
	}
	if nextRight < heapSize && nums[nextRight] < nums[smallest] {
		smallest = nextRight
	}
	if smallest != index {
		nums[index], nums[smallest] = nums[smallest], nums[index]
		smallHeapify(nums, smallest, heapSize)
	}
}

func (this *MedianFinder) thisLargeHeapify(){
	largeHeapify(this.smallNums, 0, len(smallNums))
}

// 小值大根堆调整
func largeHeapify(nums []int, index, heapSize){
	largest, nextLeft, nextRight := index, index * 2 + 1, index * 2 + 2
	if nextLeft < heapSize && nums[nextLeft] > nums[largest] {
		largest = nextLeft
	}
	if nextRight < heapSize && nums[nextRight] > nums[largest] {
		largest = nextRight
	}
	if largest != index {
		nums[index], nums[largest] = nums[largest], nums[index]
		largeHeapify(nums, largest, heapSize)
	}
}