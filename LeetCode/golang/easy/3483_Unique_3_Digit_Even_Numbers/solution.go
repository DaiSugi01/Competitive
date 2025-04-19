package unique_3_Digit_Even_Numbers

import "sort"

func totalNumbers(digits []int) int {
	// 重複排除のためのセット（map[int]struct{}）
	candidateSet := make(map[int]struct{})
	n := len(digits)
	sort.Ints(digits)
	for i := 0; i < n; i++ {
		if digits[i] == 0 {
			continue
		}
		for j := 0; j < n; j++ {
			if i == j {
				continue
			}
			for k := 0; k < n; k++ {
				if k == i || k == j {
					continue
				}
				if digits[k]%2 != 0 {
					continue
				}
				num := digits[i]*100 + digits[j]*10 + digits[k]
				candidateSet[num] = struct{}{}
			}
		}
	}
	return len(candidateSet)
}
