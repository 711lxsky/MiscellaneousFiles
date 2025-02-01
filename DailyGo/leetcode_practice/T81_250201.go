package leetcode_practice

func search(nums []int, target int) bool {
	// 相当于是部分有序的情况下进行二分查找
	n := len(nums)
	if n == 0 {
		return false
	}
	left, right := 0, n-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return true
		}
		if nums[left] == nums[right] {
			left++
		} else {
			if nums[left] > nums[mid] {
				// 右侧有序
				if nums[mid] < target && target <= nums[right] {
					left = mid + 1
				} else {
					right = mid - 1
				}
			} else {
				// 左侧有序
				if nums[left] <= target && target < nums[mid] {
					right = mid - 1
				} else {
					left = mid + 1
				}
			}
		}
	}
	return false
}
