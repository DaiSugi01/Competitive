package _701_Compute_Alternating_Sum

// https://leetcode.com/problems/compute-alternating-sum/
func alternatingSum(nums []int) int {
	var sum int
	for i, num := range nums {
		if i%2 == 0 {
			sum += num
		} else {
			sum -= num
		}
	}

	return sum
}
