package _427_Sum_of_Variable_Length_Subarrays

func subarraySum(nums []int) int {
	var res int
	for i, n := range nums {
		start := max(0, i-n)
		for j := start; j <= i; j++ {
			res += nums[j]
		}
	}

	return res
}
