package maximum_Unique_Subarray_Sum_After_Deletion

import "math"

func maxSum(nums []int) int {
	sum := math.MinInt64
	memo := make(map[int]bool)
	for _, num := range nums {
		if _, ok := memo[num]; ok {
			continue
		}
		memo[num] = true

		if sum >= 0 && num > 0 {
			sum += num
		} else {
			sum = max(sum, num)
		}
	}

	return sum
}

func MaxSum(nums []int) int {
	return maxSum(nums)
}
