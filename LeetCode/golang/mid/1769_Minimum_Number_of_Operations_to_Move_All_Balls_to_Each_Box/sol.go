package _769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box

import "math"

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
func minOperations(boxes string) []int {
	memo := make([]int, 0, len(boxes))
	for i, b := range boxes {
		if b == '1' {
			memo = append(memo, i)
		}
	}

	ans := make([]int, len(boxes))
	for i := 0; i < len(boxes); i++ {
		sum := 0
		for _, v := range memo {
			sum += int(math.Abs(float64(i - v)))
		}
		ans[i] = sum
	}

	return ans
}

func MinOperations(boxes string) []int {
	return minOperations(boxes)
}
