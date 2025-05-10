package _807_Insert_Greatest_Common_Divisors_in_Linked_List

// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
func insertGreatestCommonDivisors(head *ListNode) *ListNode {
	curr := head
	for curr.Next != nil {
		next := curr.Next
		curr.Next = &ListNode{
			Val:  gcd(curr.Val, next.Val),
			Next: next,
		}
		curr = next
	}

	return head
}

func gcd(a, b int) int {
	for b != 0 {
		t := b
		b = a % b
		a = t
	}
	return a
}

type ListNode struct {
	Val  int
	Next *ListNode
}
