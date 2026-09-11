package _64_Largest_Plus_Sign

import (
	"math"
)

// https://leetcode.com/problems/largest-plus-sign/?envType=company&envId=twitter&favoriteSlug=twitter-six-months
func orderOfLargestPlusSign(n int, mines [][]int) int {
	block := make(map[int]struct{}, len(mines))
	for _, m := range mines {
		block[m[0]*n+m[1]] = struct{}{}
	}

	left := make([][]int, n)
	right := make([][]int, n)
	up := make([][]int, n)
	down := make([][]int, n)
	for i := 0; i < n; i++ {
		left[i] = make([]int, n)
		right[i] = make([]int, n)
		up[i] = make([]int, n)
		down[i] = make([]int, n)
	}

	for r := 0; r < n; r++ {
		run := 0
		for c := 0; c < n; c++ { // left
			if _, ok := block[r*n+c]; ok {
				run = 0
			} else {
				run++
			}
			left[r][c] = run
		}
		run = 0
		for c := n - 1; c >= 0; c-- { // right
			if _, ok := block[r*n+c]; ok {
				run = 0
			} else {
				run++
			}
			right[r][c] = run
		}
	}

	for c := 0; c < n; c++ {
		run := 0
		for r := 0; r < n; r++ { // up
			if _, ok := block[r*n+c]; ok {
				run = 0
			} else {
				run++
			}
			up[r][c] = run
		}
		run = 0
		for r := n - 1; r >= 0; r-- { // down
			if _, ok := block[r*n+c]; ok {
				run = 0
			} else {
				run++
			}
			down[r][c] = run
		}
	}
	best := 0
	for r := 0; r < n; r++ {
		for c := 0; c < n; c++ {
			k := left[r][c]
			k = int(math.Min(float64(k), float64(right[r][c])))
			k = int(math.Min(float64(k), float64(up[r][c])))
			k = int(math.Min(float64(k), float64(down[r][c])))
			best = int(math.Max(float64(best), float64(k)))
		}
	}

	return best
}
