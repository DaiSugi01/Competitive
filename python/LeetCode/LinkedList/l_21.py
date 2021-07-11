# https://leetcode.com/problems/merge-two-sorted-lists/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeTwoLists(l1: ListNode, l2: ListNode) -> ListNode:
    pre_head: ListNode = ListNode(-1)
    prev: ListNode = pre_head

    while l1 and l2:
        if l1.val <= l2.val:
            prev.next = ListNode(l1.val)
            l1 = l1.next
        else:
            prev.next = ListNode(l2.val)
            l2 = l2.next
        prev = prev.next

    prev.next = l1 if l1 else l2

    return pre_head.next

