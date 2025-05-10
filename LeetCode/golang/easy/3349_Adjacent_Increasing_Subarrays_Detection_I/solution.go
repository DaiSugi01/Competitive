package _349_Adjacent_Increasing_Subarrays_Detection_I

// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/
func hasIncreasingSubarrays(nums []int, k int) bool {
	suffix := make([]int, len(nums))
	suffix[len(nums)-1] = 1
	for i := len(nums) - 2; i >= 0; i-- {
		if nums[i+1] > nums[i] {
			suffix[i] = suffix[i+1] + 1
		} else {
			suffix[i] = 1
		}
	}

	for i := 0; i < len(suffix)-k; i++ {
		if suffix[i] >= k && suffix[i+k] >= k {
			return true
		}
	}

	return false
}

func HasIncreasingSubarrays(nums []int, k int) bool {
	return hasIncreasingSubarrays(nums, k)
}
