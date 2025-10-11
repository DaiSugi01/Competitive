package _110_score_of_a_string

import (
	"math"
)

// https://leetcode.com/problems/score-of-a-string/description/
func ScoreOfString(s string) int {
	if len(s) <= 0 {
		return 0
	}

	var sum float64
	for i := 0; i < len(s)-1; i++ {
		sum += math.Abs(float64(s[i]) - float64(s[i+1]))
	}

	return int(sum)
}
