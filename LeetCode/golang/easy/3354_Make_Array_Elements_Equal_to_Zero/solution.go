package _354_Make_Array_Elements_Equal_to_Zero

import "math"

// https://leetcode.com/problems/make-array-elements-equal-to-zero/
func countValidSelections(nums []int) int {
	prefix := make([]int, len(nums))
	prefix[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		prefix[i] = prefix[i-1] + nums[i]
	}
	suffix := make([]int, len(nums))
	suffix[len(nums)-1] = nums[len(nums)-1]
	for i := len(nums) - 2; i >= 0; i-- {
		suffix[i] = suffix[i+1] + nums[i]
	}

	var res int
	for i, n := range nums {
		if n != 0 {
			continue
		}
		diff := int(math.Abs(float64(prefix[i] - suffix[i])))
		if diff == 0 {
			res += 2
		} else if diff == 1 {
			res++
		}
	}

	return res
}

func CountValidSelections(nums []int) int {
	return countValidSelections(nums)
}
