package _438_Find_Valid_Pair_of_Adjacent_Digits_in_String

// https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
func findValidPair(s string) string {
	freq := make([]int, 10)
	for i := 0; i < len(s); i++ {
		freq[int(s[i]-'0')]++
	}

	for i := 0; i < len(s)-1; i++ {
		val := int(s[i] - '0')
		next := int(s[i+1] - '0')
		if val != next && freq[val] == val && freq[next] == next {
			return s[i : i+2]
		}
	}

	return ""
}

func FindValidPair(s string) string {
	return findValidPair(s)
}
