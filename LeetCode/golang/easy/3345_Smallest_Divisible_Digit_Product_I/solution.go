package _345_Smallest_Divisible_Digit_Product_I

func smallestNumber(n int, t int) int {
	for {
		rest := n
		prod := 1
		for {
			d := n % 10
			prod *= d
			rest /= 10
			if rest < 10 {
				break
			}
		}

		if rest > 0 {
			prod *= rest
		}
		if prod%t == 0 {
			return n
		}
		n++
	}
}

func SmallestNumber(n int, t int) int {
	return smallestNumber(n, t)
}
