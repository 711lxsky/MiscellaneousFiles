package LeetCode_Hot100

func countBalls(lowLimit int, highLimit int) (ans int) {
	record := map[int]int{}
	for i := lowLimit; i <= highLimit; i++ {
		boxNum, num := 0, i
		for num > 0 {
			boxNum += num % 10
			num /= 10
		}
		record[boxNum]++
		if record[boxNum] > ans {
			ans = record[boxNum]
		}
	}
	return
}
