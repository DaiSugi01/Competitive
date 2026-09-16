package _3517_Smallest_Palindromic_Rearrangement_I

import (
	"fmt"
)

/*
https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/
3517. Smallest Palindromic Rearrangement I
Medium
Topics
premium lock icon
Companies
Hint
You are given a palindromic string s.

Return the lexicographically smallest palindromic permutation of s.

Example 1:

Input: s = "z"

Output: "z"

Explanation:

A string of only one character is already the lexicographically smallest palindrome.

Example 2:

Input: s = "babab"

Output: "abbba"

Explanation:

Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

Example 3:

Input: s = "daccad"

Output: "acddca"

Explanation:

Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
s is guaranteed to be palindromic.
*/
func smallestPalindrome(s string) string {
	var count [26]int
	for i := 0; i < len(s); i++ {
		count[s[i]-'a']++
	}

	n := len(s)
	res := make([]byte, n)
	left := 0

	for c := 0; c < 26; c++ {
		if count[c]%2 == 1 {
			res[n/2] = byte('a' + c)
		}
		for i := 0; i < count[c]/2; i++ {
			res[left] = byte('a' + c)
			res[n-1-left] = byte('a' + c)
			left++
		}
	}

	return string(res)
}

func Sol() {
	fmt.Println(smallestPalindrome("z"))
	fmt.Println(smallestPalindrome("babab"))
	fmt.Println(smallestPalindrome("daccad"))
}
