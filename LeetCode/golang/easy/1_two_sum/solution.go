package __two_sum

func twoSum(nums []int, target int) []int {
	memo := make(map[int]int)
	for i, num := range nums {
		if idx, ok := memo[target-num]; ok {
			return []int{i, idx}
		}
		memo[num] = i
	}

	return []int{}
}
