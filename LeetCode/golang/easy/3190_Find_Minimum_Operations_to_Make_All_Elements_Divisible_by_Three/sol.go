package _190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three

func minimumOperations(nums []int) int {
	var res int
	for _, n := range nums {
		mod := n % 3
		if mod == 0 {
			continue
		}
		if mod > 3/2 {
			res += 3 - mod
		} else {
			res += mod
		}
	}

	return res
}

func MinimumOperations(nums []int) int {
	return minimumOperations(nums)
}
