package minimum_Operations_to_Make_Array_Sum_Divisible_by_K

// https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/
func minOperations(nums []int, k int) int {
	var sum int
	for _, num := range nums {
		sum += num
	}

	return sum % k
}
