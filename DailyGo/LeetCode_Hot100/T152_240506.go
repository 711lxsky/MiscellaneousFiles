package LeetCode_Hot100

func maxProduct(nums []int) (res int) {
	maxProduct, minProduct := nums[0], nums[0]
	res = maxProduct
	for _, num := range nums[1:] {
		tmpMaxProduct := max(minProduct*num, max(num, maxProduct*num))
		tmpMinProduct := min(maxProduct*num, min(num, minProduct*num))
		maxProduct = tmpMaxProduct
		minProduct = tmpMinProduct
		res = max(res, maxProduct)
	}
	return
}
