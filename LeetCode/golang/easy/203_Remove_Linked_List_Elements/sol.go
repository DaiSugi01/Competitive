package _203_Remove_Linked_List_Elements

import (
	"fmt"
)

/*
https://leetcode.com/problems/remove-linked-list-elements/description/

203. Remove Linked List Elements
Easy
Topics
premium lock icon
Companies
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
*/
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeElements(head *ListNode, val int) *ListNode {
	dummy := &ListNode{Next: head}
	prev := dummy
	for node := prev; node != nil; node = node.Next {
		if node.Val == val {
			prev.Next = node.Next
		} else {
			prev = node
		}
	}

	return dummy.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func Sol() {
	//l7 := &ListNode{Val: 6}
	//l6 := &ListNode{Val: 5, Next: l7}
	//l5 := &ListNode{Val: 4, Next: l6}
	//l4 := &ListNode{Val: 3, Next: l5}
	//l3 := &ListNode{Val: 6, Next: l4}
	//l2 := &ListNode{Val: 2, Next: l3}
	//l1 := &ListNode{Val: 1, Next: l2}
	//res := removeElements(l1, 6)

	l4 := &ListNode{Val: 7}
	l3 := &ListNode{Val: 7, Next: l4}
	l2 := &ListNode{Val: 7, Next: l3}
	l1 := &ListNode{Val: 7, Next: l2}
	res := removeElements(l1, 7)

	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
