package _364_Minimum_Positive_Sum_Subarray

import "math"

// You are given an integer array nums and two integers l and r. A subarray is a contiguous non‐empty sequence of elements within the array. Find a subarray of length between l and r (inclusive) whose sum is strictly negative and as large as possible (that is, closest to zero). Return that maximum negative sum. If no such subarray exists, return 0.
func gpt(nums []int, l int, r int) int {
	n := len(nums)
	prefix := make([]int, n+1)
	for i, num := range nums {
		prefix[i+1] = prefix[i] + num
	}

	const inf = math.MinInt64
	res := inf
	for i := 0; i < n; i++ {
		for length := l; length <= r; length++ {
			j := i + length
			if j > n {
				break
			}
			sum := prefix[j] - prefix[i]
			if sum < 0 {
				res = max(res, sum)
			}
		}
	}

	if res == inf {
		return 0
	}

	return res
}

func Gpt(nums []int, l int, r int) int {
	return gpt(nums, l, r)
}

func gpt2(nums []int, l, r, target int) int {
	n := len(nums)
	prefix := make([]int, n+1)
	for i := 0; i < n; i++ {
		prefix[i+1] = prefix[i] + nums[i]
	}

	res := math.MinInt64
	minDiff := math.MaxInt64
	for i := 0; i < n; i++ {
		for length := l; length <= r; length++ {
			j := i + length
			if j > n {
				break
			}
			sum := prefix[j] - prefix[i]
			diff := int(math.Abs(float64(target - sum)))
			if diff > minDiff {
				continue
			}

			if diff == minDiff {
				res = max(res, sum)
			} else {
				res = sum
				minDiff = diff
			}
		}
	}

	return res
}

func Gpt2(nums []int, l, r, target int) int {
	return gpt2(nums, l, r, target)
}
