package LeetCode_Hot100

/*
	返回出现频率最高的前 k 个数，

当前思路是先一次遍历把记录存进去(pair记录键值对，键为数，值为次数)，
然后建大根堆，以值为第一排序字段
*/


type Pair struct {
	num int
	time int
}

func topKFrequent(nums []int, k int) ( res []int) {
	record := map[int]int{}
	for _, num := range nums {
		record[num] ++
	}
	pairs := []Pair{}
	for num, time := range record {
		newPair := Pair{num, time}
        pairs = append(pairs, newPair)
	}
	heapSize, n := len(pairs), len(pairs)
	buildPairHeap(pairs, heapSize)
	for i := n - 1; i >= n - k ; i -- {
		res = append(res, pairs[0].num)
		pairs[0], pairs[i] = pairs[i], pairs[0]
		heapSize --
		maxPairHeapify(pairs, 0, heapSize)
	}
	return
}

func buildPairHeap(pairs []Pair, heapSize int){
	// 建的时候应该是 size / 2， 相当于叶子不用管，自底向上找大值
	for i := heapSize / 2; i >= 0; i -- {
		maxPairHeapify(pairs, i, heapSize)
	}
}

func maxPairHeapify(pairs []Pair, index int, heapSize int){
	largest, nextLeft, nextRight := index, index * 2 + 1, index * 2 + 2
	if nextLeft < heapSize && pairs[nextLeft].time > pairs[largest].time {
		largest = nextLeft
	}
	if nextRight < heapSize && pairs[nextRight].time > pairs[largest].time {
		largest = nextRight
	}
	if largest != index {
		pairs[largest], pairs[index] = pairs[index], pairs[largest]
		maxPairHeapify(pairs, largest, heapSize)
	}
}
