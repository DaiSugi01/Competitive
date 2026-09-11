package _145_Binary_Tree_Postorder_Traversal_

/*
https://leetcode.com/problems/binary-tree-postorder-traversal/

145. Binary Tree Postorder Traversal
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, return the postorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]



Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
*/

func postorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)

	var helper func(node *TreeNode)
	helper = func(node *TreeNode) {
		if node == nil {
			return
		}

		helper(node.Left)
		helper(node.Right)

		res = append(res, node.Val)
	}
	helper(root)
	return res
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
