package LeetCode_Hot100

func majorityElement(nums []int) int {
	candidate, cnt := 0, 0
	for _, num := range nums {
		if cnt == 0 {
			candidate = num
		}
		if candidate == num {
			cnt++
		} else {
			cnt--
		}
	}
	return candidate
}
