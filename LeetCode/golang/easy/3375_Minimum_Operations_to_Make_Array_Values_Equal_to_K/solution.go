package _375_Minimum_Operations_to_Make_Array_Values_Equal_to_K

// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/
func minOperations(nums []int, k int) int {
	set := make(map[int]struct{})
	for _, num := range nums {
		if num < k {
			return -1
		} else if num > k {
			set[num] = struct{}{}
		}
	}
	return len(set)
}
