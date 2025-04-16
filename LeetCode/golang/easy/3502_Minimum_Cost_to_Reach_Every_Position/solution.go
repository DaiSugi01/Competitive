package minimum_Cost_to_Reach_Every_Position

import "math"

func minCosts(cost []int) []int {
	res := make([]int, len(cost))
	minCost := math.MaxInt
	for i, c := range cost {
		minCost = min(c, minCost)
		res[i] = minCost
	}

	return res
}
