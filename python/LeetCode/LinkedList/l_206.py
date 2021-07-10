# https://leetcode.com/problems/reverse-linked-list/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverseList(head: ListNode) -> ListNode:
    prev: ListNode = None
    curr: ListNode = head

    while curr:
        temp_next: ListNode = curr.next
        prev = curr
        curr.next = prev
        curr = temp_next

    return prev
