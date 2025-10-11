package _181_Merge_Nodes_in_Between_Zeros

type ListNode struct {
	Val  int
	Next *ListNode
}

func NewListNode() *ListNode {
	head := &ListNode{Val: 0}
	head.Next = &ListNode{Val: 3}
	head.Next.Next = &ListNode{Val: 1}
	head.Next.Next.Next = &ListNode{Val: 0}
	head.Next.Next.Next.Next = &ListNode{Val: 4}
	head.Next.Next.Next.Next.Next = &ListNode{Val: 5}
	head.Next.Next.Next.Next.Next.Next = &ListNode{Val: 2}
	head.Next.Next.Next.Next.Next.Next.Next = &ListNode{Val: 0}
	return head
}

func mergeNodes(head *ListNode) *ListNode {
	modify := head.Next
	curr := modify
	for curr != nil {
		var sum int
		for curr.Val != 0 {
			sum += curr.Val
			curr = curr.Next
		}
		modify.Val = sum
		curr = curr.Next
		modify.Next = curr
		modify = modify.Next
	}

	return head.Next
}

func MergeNodes(head *ListNode) *ListNode {
	return mergeNodes(head)
}
