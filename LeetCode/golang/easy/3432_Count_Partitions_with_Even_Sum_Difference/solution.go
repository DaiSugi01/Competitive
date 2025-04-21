package _432_Count_Partitions_with_Even_Sum_Difference

func countPartitions(nums []int) int {
	left := make([]int, len(nums))
	left[0] = nums[0]
	right := make([]int, len(nums))
	right[len(nums)-1] = nums[len(nums)-1]

	for i := 1; i < len(nums); i++ {
		left[i] = left[i-1] + nums[i]
	}

	for i := len(nums) - 2; i >= 0; i-- {
		right[i] = right[i+1] + nums[i]
	}

	var res int
	for i := 0; i < len(left)-1; i++ {
		if (left[i]-right[i+1])%2 == 0 {
			res++
		}
	}

	return res
}

func CountPartitions(nums []int) int {
	return countPartitions(nums)
}
