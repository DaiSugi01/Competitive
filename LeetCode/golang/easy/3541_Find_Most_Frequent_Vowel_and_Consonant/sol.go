package _541_Find_Most_Frequent_Vowel_and_Consonant

import (
	"strings"
)

func MaxFreqSum(s string) int {
	var fv, fc int
	vowels := "aeiou"
	vowelMap := make(map[byte]int)
	consonantMap := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		if strings.IndexByte(vowels, s[i]) >= 0 {
			if _, ok := vowelMap[s[i]]; ok {
				vowelMap[s[i]]++
			} else {
				vowelMap[s[i]] = 1
			}

			if vowelMap[s[i]] > fv {
				fv = vowelMap[s[i]]
			}
		} else {
			if _, ok := consonantMap[s[i]]; ok {
				consonantMap[s[i]]++
			} else {
				consonantMap[s[i]] = 1
			}

			if consonantMap[s[i]] > fc {
				fc = consonantMap[s[i]]
			}
		}
	}

	return fv + fc
}
