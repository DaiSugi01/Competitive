package _314_Construct_the_Minimum_Bitwise_Array_I

func minBitwiseArray(nums []int) []int {
	ans := make([]int, len(nums))
	for i, num := range nums {
		ans[i] = -1
		for j := 1; j < num; j++ {
			if (j | (j + 1)) == num {
				ans[i] = j
				break
			}
		}
	}

	return ans
}

func MinBitwiseArray(nums []int) []int {
	return minBitwiseArray(nums)
}
