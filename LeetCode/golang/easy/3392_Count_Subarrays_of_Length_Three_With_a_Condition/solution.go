package _392_Count_Subarrays_of_Length_Three_With_a_Condition

// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
func countSubarrays(nums []int) int {
	var res int
	for i := 0; i < len(nums)-2; i++ {
		first := nums[i]
		second := nums[i+1]
		third := nums[i+2]
		if (first+third)*2 == second {
			res++
		}
	}

	return res
}

func CountSubarrays(nums []int) int {
	return countSubarrays(nums)
}
