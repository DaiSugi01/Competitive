package q2

import (
	"math"
	"slices"
)

func maxAlternatingSum(nums []int) int64 {
	slices.SortStableFunc(nums, func(v1, v2 int) int {
		return int(math.Abs(float64(v2)) - math.Abs(float64(v1)))
	})

	var offset int
	if len(nums)%2 != 0 {
		offset = 1
	}
	length := len(nums)/2 + offset
	larger := nums[:length]
	smaller := nums[length:]

	var sum int64
	for i := 0; i < len(nums)/2; i++ {
		sum += int64(math.Pow(float64(larger[i]), 2) - math.Pow(float64(smaller[i]), 2))
	}

	if offset == 1 {
		sum += int64(math.Pow(float64(larger[len(larger)-1]), 2))
	}

	return sum
}

func MaxAlternatingSum(nums []int) int64 {
	return maxAlternatingSum(nums)
}
