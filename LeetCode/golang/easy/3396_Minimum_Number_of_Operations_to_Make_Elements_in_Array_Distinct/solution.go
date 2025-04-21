package _396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct

// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/submissions/1613869872/
func minimumOperations(nums []int) int {
	memo := make(map[int]bool)
	for i := len(nums) - 1; i >= 0; i-- {
		if _, ok := memo[nums[i]]; ok {
			return (i + 3) / 3
		}
		memo[nums[i]] = true
	}

	return 0
}

func MinimumOperations(nums []int) int {
	return minimumOperations(nums)
}
