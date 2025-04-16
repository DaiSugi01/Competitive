package minimum_Pair_Removal_to_Sort_Array_I

import "math"

// https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/
// isNonDecreasing は配列が非減少（non-decreasing）かを判定する
func isNonDecreasing(nums []int) bool {
	for i := 1; i < len(nums); i++ {
		if nums[i] < nums[i-1] {
			return false
		}
	}
	return true
}

// minimumOperations は指定された操作を繰り返し、配列が非減少になるまで必要な操作回数を返す
func minimumOperations(nums []int) int {
	opCount := 0

	if isNonDecreasing(nums) {
		return 0
	}

	for len(nums) > 1 && !isNonDecreasing(nums) {
		minSum := math.MaxInt64
		idx := 0
		// 隣接するペアの中で、和が最小のペア（複数あれば左側）を探す
		for i := 0; i < len(nums)-1; i++ {
			sum := nums[i] + nums[i+1]
			if sum < minSum {
				minSum = sum
				idx = i
			}
		}
		newNums := make([]int, 0, len(nums)-1)
		newNums = append(newNums, nums[:idx]...)
		newNums = append(newNums, minSum)
		newNums = append(newNums, nums[idx+2:]...)
		nums = newNums

		opCount++
	}

	return opCount
}

// [2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1]
// [2, 2, -1, 3, -2, 2, 1, 1, 1, -1]
// [2, 2, -1, 3, -2, 2, 1, 1, 0]
// [2, 2, -1, 3, -2, 2, 1, 1]
// [2, 2, -1, 3, -2, 3, 1]
// [2, 2, -1, 1, 3, 1]
// [2, 1, 1, 3, 1]
// [3, 1, 3, 1]
// ------
// [3, 5]
func MinimumPairRemoval(nums []int) int {
	return minimumOperations(nums)
}
