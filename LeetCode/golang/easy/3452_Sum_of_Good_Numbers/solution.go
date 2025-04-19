package sum_of_Good_Numbers

func sumOfGoodNumbers(nums []int, k int) int {
	n := len(nums)
	var res int
	for i := 0; i < n; i++ {
		leftValid := i-k < 0 || nums[i] > nums[i-k]
		rightValid := i+k >= n || nums[i] > nums[i+k]

		if leftValid && rightValid {
			res += nums[i]
		}
	}

	return res
}

func SumOfGoodNumbers(nums []int, k int) int {
	return sumOfGoodNumbers(nums, k)
}
