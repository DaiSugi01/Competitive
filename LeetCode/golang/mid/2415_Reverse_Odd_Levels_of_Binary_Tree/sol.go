package _2415_Reverse_Odd_Levels_of_Binary_Tree

import (
	"fmt"
)

/*
https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
2415. Reverse Odd Levels of Binary Tree
Medium
Topics
premium lock icon
Companies
Hint
Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
Return the root of the reversed tree.

A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

The level of a node is the number of edges along the path between it and the root node.

Example 1:

Input: root = [2,3,5,8,13,21,34]
Output: [2,5,3,8,13,21,34]
Explanation:
The tree has only one odd level.
The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
Example 2:

Input: root = [7,13,11]
Output: [7,11,13]
Explanation:
The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
Example 3:

Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
Explanation:
The odd levels have non-zero values.
The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.

Constraints:

The number of nodes in the tree is in the range [1, 214].
0 <= Node.val <= 105
root is a perfect binary tree.
*/
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func reverseOddLevels(root *TreeNode) *TreeNode {
	level := 0
	q := []*TreeNode{root}

	for len(q) > 0 {
		if level%2 == 1 {
			for i := 0; i < len(q)/2; i++ {
				q[i].Val, q[len(q)-1-i].Val = q[len(q)-1-i].Val, q[i].Val
			}
		}

		l := len(q)
		for _, n := range q {
			if n.Left != nil {
				q = append(q, n.Left, n.Right)
			}
		}

		q = q[l:]
		level++
	}

	return root
}

func reverseOddLevelsDfs(root *TreeNode) *TreeNode {
	var dfs func(*TreeNode, *TreeNode, int)
	dfs = func(a, b *TreeNode, level int) {
		if a == nil {
			return
		}

		if level%2 == 1 {
			a.Val, b.Val = b.Val, a.Val
		}
		dfs(a.Left, b.Right, level+1)
		dfs(a.Right, b.Left, level+1)
	}

	dfs(root.Left, root.Right, 1)
	return root
}

func Sol() {
	printTree(reverseOddLevelsDfs(BuildTree([]int{2, 3, 5, 8, 13, 21, 34})))
	fmt.Println("")
	printTree(reverseOddLevels(BuildTree([]int{0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2})))
}

func BuildTree(vals []int) *TreeNode {
	if len(vals) == 0 {
		return nil
	}

	nodes := make([]*TreeNode, len(vals))
	for i, v := range vals {
		nodes[i] = &TreeNode{Val: v}
	}
	for i := range nodes {
		if l := 2*i + 1; l < len(nodes) {
			nodes[i].Left = nodes[l]
		}
		if r := 2*i + 2; r < len(nodes) {
			nodes[i].Right = nodes[r]
		}
	}
	return nodes[0]
}

func printTree(root *TreeNode) {
	if root == nil {
		return
	}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		size := len(queue)
		vals := make([]int, 0, size)
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			vals = append(vals, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		fmt.Println(vals)
	}
}
