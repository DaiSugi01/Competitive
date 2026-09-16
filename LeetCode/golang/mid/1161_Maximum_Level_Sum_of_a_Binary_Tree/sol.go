package _1161_Maximum_Level_Sum_of_a_Binary_Tree

import (
	"fmt"
	"math"
)

/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
1161. Maximum Level Sum of a Binary Tree
Medium
Topics
premium lock icon
Companies
Hint
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:

Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxLevelSum(root *TreeNode) int {
	q := []*TreeNode{root}
	maxSum := math.MinInt
	level, currentLevel := 1, 1

	for len(q) > 0 {
		n := len(q)
		currentSum := 0
		for i := 0; i < n; i++ {
			currentSum += q[i].Val
			if q[i].Left != nil {
				q = append(q, q[i].Left)
			}
			if q[i].Right != nil {
				q = append(q, q[i].Right)
			}
		}
		q = q[n:]

		if currentSum > maxSum {
			maxSum = currentSum
			level = currentLevel
		}
		currentLevel++
	}

	return level
}

func Sol() {
	root := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 7,
			Left: &TreeNode{
				Val: 7,
			},
			Right: &TreeNode{
				Val: -8,
			},
		},
		Right: &TreeNode{
			Val: 0,
		},
	}

	fmt.Println(maxLevelSum(root))
}
