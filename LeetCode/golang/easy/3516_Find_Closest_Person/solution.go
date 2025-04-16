package find_Closest_Person

import "math"

// findClosest is for https://leetcode.com/problems/find-closest-person/description/
func findClosest(x int, y int, z int) int {
	fp := math.Abs(float64(z - x))
	sp := math.Abs(float64(z - y))

	if fp > sp {
		return 2
	} else if fp < sp {
		return 1
	}
	return 0
}
