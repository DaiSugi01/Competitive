package _289_The_Two_Sneaky_Numbers_of_Digitville

// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
func getSneakyNumbers(nums []int) []int {
	res := make([]int, 0, 2)
	memo := make(map[int]struct{})
	for _, n := range nums {
		if _, ok := memo[n]; !ok {
			memo[n] = struct{}{}
		} else {
			res = append(res, n)
		}
	}

	return res
}
