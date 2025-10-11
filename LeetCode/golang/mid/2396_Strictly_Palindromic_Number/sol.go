package _396_Strictly_Palindromic_Number

import "strconv"

// https://leetcode.com/problems/strictly-palindromic-number/
func isStrictlyPalindromic(n int) bool {
	for b := 2; b <= n-2; b++ {
		binary := strconv.FormatInt(int64(n), b)
		l := 0
		r := len(binary) - 1
		palindromic := false
		for l <= r {
			if binary[l] != binary[r] {
				palindromic = false
				break
			}
			palindromic = true
			l++
			r--
		}
		if !palindromic {
			return false
		}
	}

	return true
}
