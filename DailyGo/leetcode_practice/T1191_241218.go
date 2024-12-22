package leetcode_practice

func kConcatenationMaxSum(arr []int, k int) int {
	var (
		sum          = int64(arr[0])
		maxSum int64 = 0
		res    int64 = 0
	)
	if arr[0] > 0 {
		maxSum = int64(arr[0])
	}
	res = maxSum
	n, lenA := min(k, 2)*len(arr), len(arr)
	for i := 1; i < n; i++ {
		if i < lenA {
			sum += int64(arr[i])
		}
		maxSum = max(maxSum+int64(arr[i%lenA]), int64(arr[i%lenA]))
		res = max(res, sum, maxSum)
	}
	if sum > 0 && k > 2 {
		res += (sum * int64(k-2)) % 1000000007
	}
	return int(res % 1000000007)
}
