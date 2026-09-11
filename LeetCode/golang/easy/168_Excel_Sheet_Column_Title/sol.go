package _168_Excel_Sheet_Column_Title

/*
https://leetcode.com/problems/excel-sheet-column-title/description/

168. Excel Sheet Column Title
Easy
Topics
premium lock icon
Companies
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"

Constraints:

1 <= columnNumber <= 231 - 1
*/

func convertToTitle(columnNumber int) string {
	var buf []byte
	for columnNumber > 0 {
		columnNumber--
		buf = append(buf, byte('A'+columnNumber%26))
		columnNumber /= 26
	}
	// 下位桁から作ったので反転する
	for i, j := 0, len(buf)-1; i < j; i, j = i+1, j-1 {
		buf[i], buf[j] = buf[j], buf[i]
	}
	return string(buf)
}

func ConvertToTitle() string {
	return convertToTitle(52)
}
