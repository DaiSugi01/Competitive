package _3751_Total_Waviness_of_Numbers_in_Range_I

import (
	"fmt"
)

/*
https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/

3751. Total Waviness of Numbers in Range I
Medium
Topics
premium lock icon
Companies
Hint
You are given two integers num1 and num2 representing an inclusive range [num1, num2].

The waviness of a number is defined as the total count of its peaks and valleys:

A digit is a peak if it is strictly greater than both of its immediate neighbors.
A digit is a valley if it is strictly less than both of its immediate neighbors.
The first and last digits of a number cannot be peaks or valleys.
Any number with fewer than 3 digits has a waviness of 0.
Return the total sum of waviness for all numbers in the range [num1, num2].

Example 1:

Input: num1 = 120, num2 = 130

Output: 3

Explanation:

In the range [120, 130]:
120: middle digit 2 is a peak, waviness = 1.
121: middle digit 2 is a peak, waviness = 1.
130: middle digit 3 is a peak, waviness = 1.
All other numbers in the range have a waviness of 0.
Thus, total waviness is 1 + 1 + 1 = 3.

Example 2:

Input: num1 = 198, num2 = 202

Output: 3

Explanation:

In the range [198, 202]:
198: middle digit 9 is a peak, waviness = 1.
201: middle digit 0 is a valley, waviness = 1.
202: middle digit 0 is a valley, waviness = 1.
All other numbers in the range have a waviness of 0.
Thus, total waviness is 1 + 1 + 1 = 3.

Example 3:

Input: num1 = 4848, num2 = 4848

Output: 2

Explanation:

Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.

Constraints:

1 <= num1 <= num2 <= 105
*/
func totalWaviness(num1 int, num2 int) int {
	var d [7]int
	w := 0
	for i := num1; i <= num2; i++ {
		n, len_ := i, 0
		for n > 0 {
			d[len_] = n % 10
			len_++
			n /= 10
		}

		for j := 1; j < len_-1; j++ {
			if (d[j] > d[j-1] && d[j] > d[j+1]) || (d[j] < d[j-1] && d[j] < d[j+1]) {
				w++
			}
		}
	}

	return w
}

func Sol() {
	fmt.Println(totalWaviness(198, 202))
}
