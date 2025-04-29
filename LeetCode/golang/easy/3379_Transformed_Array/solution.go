package _379_Transformed_Array

// https://leetcode.com/problems/transformed-array/
func constructTransformedArray(nums []int) []int {
	n := len(nums)
	res := make([]int, n)

	for i, k := range nums {
		dst := (i + k) % n
		if dst < 0 {
			dst += n
		}
		res[i] = nums[dst]
	}

	return res
}

// [1,-2.3.4.5]
