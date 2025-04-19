package fruits_Into_Baskets_II

// https://leetcode.com/problems/transform-array-by-parity/description/
func transformArray(nums []int) []int {
	res := make([]int, len(nums))
	currentIdx := len(nums) - 1
	for i := 0; i < len(nums); i++ {
		if nums[i]%2 != 0 {
			res[currentIdx] = 1
			currentIdx--
		}
	}

	return res
}
