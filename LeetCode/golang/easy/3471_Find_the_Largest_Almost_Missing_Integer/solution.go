package fruits_Into_Baskets_II

// https://leetcode.com/problems/find-the-largest-almost-missing-integer/
func largestInteger(nums []int, k int) int {
	memo := make([]int, 51)
	for i := 0; i <= len(nums)-k; i++ {
		memoMap := make(map[int]bool)
		for j := 0; j < k; j++ {
			if _, ok := memoMap[nums[i+j]]; ok {
				continue
			}
			memo[nums[i+j]]++
			memoMap[nums[i+j]] = true
		}
	}

	maxNum := -1
	for i, n := range memo {
		if n == 1 {
			maxNum = i
		}
	}

	return maxNum
}
