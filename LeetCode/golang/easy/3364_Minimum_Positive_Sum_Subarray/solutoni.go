package _364_Minimum_Positive_Sum_Subarray

import "math"

// https://leetcode.com/problems/minimum-positive-sum-subarray/
func minimumSumSubarray(nums []int, l int, r int) int {
	n := len(nums)
	prefix := make([]int, n+1)
	for i := 0; i < n; i++ {
		prefix[i+1] = prefix[i] + nums[i]
	}

	const INF = math.MaxInt
	ans := INF

	for i := 0; i < n; i++ {
		for length := l; length <= r; length++ {
			j := i + length
			if j > n {
				break
			}
			sum := prefix[j] - prefix[i]
			if sum > 0 && sum < ans {
				ans = sum
			}
		}
	}

	if ans == INF {
		return -1
	}

	return ans
}

func MinimumSumSubarray(nums []int, l int, r int) int {
	return minimumSumSubarray(nums, l, r)
}

// [3,-2,1,4]
// [0,3,1,2,6]
