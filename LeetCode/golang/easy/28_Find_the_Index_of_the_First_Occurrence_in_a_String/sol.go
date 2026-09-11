package _28_Find_the_Index_of_the_First_Occurrence_in_a_String

/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/2123240511/

28. Find the Index of the First Occurrence in a String
Easy
Topics
premium lock icon
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/
func strStr(haystack string, needle string) int {
	n, m := len(haystack), len(needle)
	for i := 0; i+m <= n; i++ {
		if haystack[i:i+m] == needle {
			return i
		}
	}

	return -1
}

func StrStr() int {
	return strStr("asafdbutsad", "sad")
}
