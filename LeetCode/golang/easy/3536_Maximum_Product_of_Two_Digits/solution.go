package _536_Maximum_Product_of_Two_Digits

import "math"

// https://leetcode.com/problems/maximum-product-of-two-digits/description/
func maxProduct(n int) int {
	first := math.MinInt64
	second := math.MinInt64
	rest := n
	for {
		rightDigit := rest % 10
		if rightDigit > first {
			second = first
			first = rightDigit
		} else if rightDigit > second {
			second = rightDigit
		}
		if rest < 10 {
			break
		}
		rest /= 10
	}

	return first * second
}

func MaxProduct(n int) int {
	return maxProduct(n)
}
