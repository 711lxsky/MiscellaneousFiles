package LeetCode_Classic150

import "strconv"

// 这种太繁琐了
func summaryRanges1(nums []int) (ans []string) {
	arrow := "->"
	n := len(nums)
	if n == 0 {
		return []string{}
	}
	if n == 1 {
		return []string{strconv.Itoa(nums[0])}
	}
	start, end := nums[0], nums[0]
	for index := 1; index < n; index++ {
		if nums[index] != nums[index-1]+1 {
			newStr := ""
			if start == end {
				newStr = strconv.Itoa(start)
			} else {
				newStr = strconv.Itoa(start) + arrow + strconv.Itoa(end)
			}
			ans = append(ans, newStr)
			start = nums[index]
		}
		end = nums[index]
		newStr := ""
		if index == n-1 {
			if start == end {
				newStr = strconv.Itoa(start)
			} else {
				newStr = strconv.Itoa(start) + arrow + strconv.Itoa(end)
			}
			ans = append(ans, newStr)
		}
	}
	return
}

func summaryRanges(nums []int) (res []string) {
	for i, n := 0, len(nums); i < n; {
		left := i
		for i++; i < n && nums[i-1]+1 == nums[i]; i++ {
		}
		// 这个比较巧妙地囊括了边界条件
		str := strconv.Itoa(nums[left])
		if left+1 < i {
			str += "->" + strconv.Itoa(nums[i-1])
		}
		res = append(res, str)
	}
	return
}
