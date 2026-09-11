package _1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n

import (
	"fmt"
)

/*
https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

1415. The k-th Lexicographical String of All Happy Strings of Length n
Medium
Topics
premium lock icon
Companies
Hint
A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

Constraints:

1 <= n <= 10
1 <= k <= 100
*/
func getHappyString(n int, k int) string {
	var res []string
	cur := make([]byte, n)
	var dfs func(int)
	dfs = func(pos int) {
		if pos == n {
			res = append(res, string(cur))
			return
		}

		for c := byte('a'); c <= 'c'; c++ {
			if pos > 0 && cur[pos-1] == c {
				continue
			}
			cur[pos] = c
			dfs(pos + 1)
		}
	}
	dfs(0)

	if len(res) < k {
		return ""
	}

	return res[k-1]
}

func Sol() {
	fmt.Println(getHappyString(1, 4))
}
