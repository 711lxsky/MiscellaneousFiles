package Interview_practice

func merge(nums1 []int, m int, nums2 []int, n int) {
	// 倒序来排列
	for index := m + n - 1; index >= 0 && m > 0 && n > 0; index-- {
		if nums1[m-1] > nums2[n-1] {
			nums1[index] = nums1[m-1]
			m--
		} else {
			nums1[index] = nums2[n-1]
			n--
		}
	}
	if n > 0 {
		copy(nums1[:n], nums2[:n])
	}
}
