package _18_4Sum

import (
	"fmt"
	"slices"
)

/*
https://leetcode.com/problems/4sum/description/

18. 4Sum
Medium
Topics
premium lock icon
Companies
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

func fourSum(nums []int, target int) [][]int {
	slices.Sort(nums)
	n := len(nums)
	res := make([][]int, 0)

	for i := 0; i < n-3; i++ {
		a := nums[i]
		if i > 0 && a == nums[i-1] {
			continue
		}
		if a+nums[i+1]+nums[i+2]+nums[i+3] > target {
			break
		}
		if a+nums[n-3]+nums[n-2]+nums[n-1] < target {
			continue
		}

		for j := i + 1; j < n-2; j++ {
			b := nums[j]
			if j > i+1 && b == nums[j-1] {
				continue
			}

			if a+nums[j]+nums[j+1]+nums[j+2] > target {
				break
			}
			if a+nums[j]+nums[n-2]+nums[n-1] < target {
				continue
			}

			k, l := j+1, n-1
			for k < l {
				c, d := nums[k], nums[l]
				sum := a + b + c + d
				switch {
				case sum < target:
					k++
				case sum > target:
					l--
				default:
					res = append(res, []int{a, b, c, d})
					k++
					l--

					for k < l && nums[k] == nums[k-1] {
						k++
					}
					for k < l && nums[l] == nums[l+1] {
						l--
					}
				}
			}
		}
	}
	return res
}

func Sol() {
	//fourSum([]int{1, 0, -1, 0, -2, 2}, 0)
	fmt.Println(fourSum([]int{-1, 0, 1, 2, -1, -4}, -1))
}
