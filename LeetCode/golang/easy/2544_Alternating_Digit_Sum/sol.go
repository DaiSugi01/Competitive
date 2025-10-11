package _544_Alternating_Digit_Sum

import (
	"math"
)

// https://leetcode.com/problems/alternating-digit-sum/
func alternateDigitSum(n int) int {
	var x int
	if int(math.Log10(float64(n))+1)%2 == 0 {
		x = -1
	} else {
		x = 1
	}

	var sum, rest int
	for n > 0 {
		rest = n % 10
		sum += rest * x
		x *= -1
		n /= 10
	}

	return sum
}

func AlternateDigitSum() int {
	return alternateDigitSum(521)
}
