package leetcode_practice

import "math"

func checkPerfectNumber(num int) bool {
	end := int(math.Sqrt(float64(num)))
	sum := 1
	for i := 2; i <= end; i++ {
		fac := num / i
		if num%i == 0 {
			sum += fac + i
		}
	}
	return sum == num
}
