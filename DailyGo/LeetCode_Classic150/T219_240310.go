package LeetCode_Classic150

// 直接上哈希表
func containsNearbyDuplicate1(nums []int, k int) bool {
	record := map[int]int{}
	for index, num := range nums {
		if numIndex, ok := record[num]; ok && index-numIndex <= k {
			return true
		}
		record[num] = index
	}
	return false
}

// 滑动窗口
func containsNearbyDuplicate(nums []int, k int) bool {
	record := map[int]bool{}
	for index, num := range nums {
		if _, ok := record[num]; ok {
			return true
		}
		if index >= k {
			delete(record, nums[index-k])
		}
		record[num] = true
	}
	return false
}
