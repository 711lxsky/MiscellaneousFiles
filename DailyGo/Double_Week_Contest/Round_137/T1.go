package Round_137

func resultsArray(nums []int, k int) []int {
	n, index := len(nums), 0
	res := make([]int, n-k+1)
	tmp := make([]int, k)
	for i := 0; i < n; i++ {
		if i < k-1 {
			tmp[i] = nums[i]
		} else {
			tmp[k-1] = nums[i]
			res[index] = findMax(tmp)
			index++
			for j := 0; j < k-1; j++ {
				tmp[j] = tmp[j+1]
			}
		}
	}
	return res
}

func findMax(nums []int) int {
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[i-1]+1 {
			return -1
		}
	}
	return nums[len(nums)-1]
}
