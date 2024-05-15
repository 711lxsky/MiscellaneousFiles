package LeetCode_Hot100

func sortColors(nums []int) {
	n := len(nums)
	cnt := make([]int, 3)
	for _, color := range nums {
		cnt[color-0]++
	}
	for i := 0; i < n; i++ {
		if cnt[0] > 0 {
			nums[i] = 0
			cnt[0]--
		} else if cnt[1] > 0 {
			nums[i] = 1
			cnt[1]--
		} else {
			nums[i] = 2
		}
	}
}
