package LeetCode_Classic150

func insert1(intervals [][]int, newInterval []int) [][]int {
	n := len(intervals)
	for index, curInterval := range intervals {
		if newInterval[0] <= curInterval[1] {
			newInterval[0] = Min(newInterval[0], curInterval[0])
		}
		if newInterval[0] <= curInterval[0] {
			i := index
			for i < n && newInterval[1] > intervals[i][1] {
				i++
			}
			var tmp [][]int
			tmp = [][]int{}
			tmp = append(tmp, intervals[:index]...)
			if i == n {
				tmp = append(tmp, newInterval)
			} else if newInterval[1] < intervals[i][0] {
				tmp = append(tmp, newInterval)
				tmp = append(tmp, intervals[i:]...)
			} else {
				newInterval[1] = intervals[i][1]
				tmp = append(tmp, newInterval)
				tmp = append(tmp, intervals[i+1:]...)
			}
			intervals = tmp
			return intervals
		}
	}
	intervals = append(intervals, newInterval)
	return intervals
}

func Min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func insert(intervals [][]int, newInterval []int) (ans [][]int) {
	left, right := newInterval[0], newInterval[1]
	ok := false
	for _, interval := range intervals {
		if right < interval[0] {
			if !ok {
				ans = append(ans, []int{left, right})
				ok = true
			}
			ans = append(ans, interval)
		} else if left > interval[1] {
			ans = append(ans, interval)
		} else {
			left = Min(left, interval[0])
			right = Max(right, interval[1])
		}
	}
	if !ok {
		ans = append(ans, []int{left, right})
	}
	return
}
