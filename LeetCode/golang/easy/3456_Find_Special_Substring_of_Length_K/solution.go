package _456_Find_Special_Substring_of_Length_K

// https://leetcode.com/problems/find-special-substring-of-length-k/
func hasSpecialSubstring(s string, k int) bool {
	n := len(s)
	if k > n {
		return false
	}

	for i := 0; i < n; {
		j := i
		for j < n && s[j] == s[i] {
			j++
		}
		runLen := j - i

		if runLen == k {
			beforeOK := i == 0 || s[i-1] != s[i]
			afterOK := j == n || s[j] != s[i]
			if beforeOK && afterOK {
				return true
			}
		}
		i = j
	}

	return false
}

func HasSpecialSubstring(s string, k int) bool {
	return hasSpecialSubstring(s, k)
}
