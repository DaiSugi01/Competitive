package fruits_Into_Baskets_II

// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
func hasSameDigits(s string) bool {
	for len(s) > 2 {
		str := make([]byte, len(s)-1)
		for i := 0; i < len(s)-1; i++ {
			str[i] = (s[i] + s[i+1] - '0') % 10
		}
		s = string(str)
	}

	return s[0] == s[1]
}

func HasSameDigits(s string) bool {
	return hasSameDigits(s)
}
