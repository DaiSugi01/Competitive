package _423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array

import "math"

func maxAdjacentDistance(nums []int) int {
	first := nums[0]
	last := nums[len(nums)-1]
	maxNum := int(math.Abs(float64(first - last)))
	for i := 0; i < len(nums)-1; i++ {
		maxNum = max(maxNum, int(math.Abs(float64(nums[i]-nums[i+1]))))
	}

	return maxNum
}
