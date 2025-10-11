package _894_Divisible_and_Non_divisible_Sums_Difference

func differenceOfSums(n int, m int) int {
	var sum int
	for i := 1; i <= n; i++ {
		if i%m == 0 {
			sum -= i
		} else {
			sum += i
		}
	}

	return sum
}
