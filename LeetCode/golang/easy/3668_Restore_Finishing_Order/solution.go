package _668_Restore_Finishing_Order

func recoverOrder(order []int, friends []int) []int {
	res := make([]int, 0, len(order))

	memo := make(map[int]struct{})
	for _, f := range friends {
		memo[f] = struct{}{}
	}

	for _, o := range order {
		if _, ok := memo[o]; ok {
			res = append(res, o)
		}
	}

	return res
}
