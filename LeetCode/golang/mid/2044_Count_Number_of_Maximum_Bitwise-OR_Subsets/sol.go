package _044_Count_Number_of_Maximum_Bitwise_OR_Subsets

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
func countMaxOrSubsets(nums []int) int {
	n := len(nums)
	maxOr := 0
	for _, x := range nums {
		maxOr |= x
	}

	count := 0
	for mask := 1; mask < (1 << n); mask++ {
		curOr := 0
		for i := 0; i < n; i++ {
			if (mask>>i)&1 == 1 {
				curOr |= nums[i]
			}
		}
		if curOr == maxOr {
			count++
		}
	}

	return count
}

func CountMaxOrSubsets(nums []int) int {
	return countMaxOrSubsets(nums)
}
