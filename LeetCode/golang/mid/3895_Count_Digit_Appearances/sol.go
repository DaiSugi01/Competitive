package _3895_Count_Digit_Appearances

import (
	"fmt"
)

/*
https://leetcode.com/problems/count-digit-appearances/description/
3895. Count Digit Appearances
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and an integer digit.

Return the total number of times digit appears in the decimal representation of all elements in nums.

Example 1:

Input: nums = [12,54,32,22], digit = 2

Output: 4

Explanation:

The digit 2 appears once in 12 and 32, and twice in 22. Thus, the total number of times digit 2 appears is 4.

Example 2:

Input: nums = [1,34,7], digit = 9

Output: 0

Explanation:

The digit 9 does not appear in the decimal representation of any element in nums, so the total number of times digit 9 appears is 0.

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 106​​​​​​​
0 <= digit <= 9
*/
func countDigitOccurrences(nums []int, digit int) int {
	count := 0
	for _, n := range nums {
		for n > 0 {
			modulo := n % 10
			if modulo == digit {
				count++
			}
			n /= 10
		}
	}

	return count
}

func Sol() {
	fmt.Println(countDigitOccurrences([]int{12, 54, 32, 22}, 1))
}
