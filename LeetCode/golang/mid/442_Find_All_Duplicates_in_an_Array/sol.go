package _42_Find_All_Duplicates_in_an_Array

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
func findDuplicates(nums []int) []int {
	res := make([]int, 0)
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
