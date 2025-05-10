package _318_Find_X_Sum_of_All_K_Long_Subarrays_I

import "sort"

type memoVal struct {
	Value int
	Count int
}

// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/
func findXSum(nums []int, k int, x int) []int {
	n := len(nums)
	res := make([]int, n-k+1)
	for i := 0; i < n-k+1; i++ {
		memoArr := make([]memoVal, 51)
		for j := i; j < i+k; j++ {
			memoArr[nums[j]].Value = nums[j]
			memoArr[nums[j]].Count++
		}
		sort.Slice(memoArr, func(i, j int) bool {
			if memoArr[i].Count == memoArr[j].Count {
				return memoArr[i].Value > memoArr[j].Value
			}
			return memoArr[i].Count > memoArr[j].Count
		})
		sum := 0
		for j := 0; j < x; j++ {
			sum += memoArr[j].Value * memoArr[j].Count
		}
		res[i] = sum
	}

	return res
}

func FindXSum(nums []int, k int, x int) []int {
	return findXSum(nums, k, x)
}
