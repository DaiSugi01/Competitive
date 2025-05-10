package _340_Check_Balanced_String

import "strconv"

func isBalanced(num string) bool {
	var even, odd int
	for i, n := range num {
		val, _ := strconv.Atoi(string(n))
		if i%2 == 0 {
			even += val
		} else {
			odd += val
		}
	}

	return even == odd
}

func IsBalanced(num string) bool {
	return isBalanced(num)
}
