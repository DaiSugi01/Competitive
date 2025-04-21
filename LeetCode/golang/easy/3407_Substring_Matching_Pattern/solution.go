package _407_Substring_Matching_Pattern

import "strings"

func hasMatch(s string, p string) bool {
	parts := strings.Split(p, "*")
	l, r := parts[0], parts[1]
	lLen, rLen := len(parts[0]), len(parts[1])
	for i := 0; i+lLen <= len(s); i++ {
		if s[i:i+lLen] != l {
			continue
		}

		if rLen == 0 {
			return true
		}

		for end := i + lLen + rLen; end <= len(s); end++ {
			if s[end-rLen:end] == r {
				return true
			}
		}
	}

	return false
}

func HasMatch(s string, p string) bool {
	return hasMatch(s, p)
}
