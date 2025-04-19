package _442_Maximum_Difference_Between_Even_and_Odd_Frequency_I

import "math"

// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
func maxDifference(s string) int {
	memo := make(map[int32]int)
	for _, c := range s {
		if _, ok := memo[c]; !ok {
			memo[c] = 1
		} else {
			memo[c]++
		}
	}

	even := math.MaxInt64
	odd := math.MinInt64
	for _, freq := range memo {
		if freq%2 == 0 {
			even = min(even, freq)
		} else {
			odd = max(odd, freq)
		}
	}

	return odd - even
}
