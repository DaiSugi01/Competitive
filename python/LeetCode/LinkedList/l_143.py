# https://leetcode.com/problems/reorder-list/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reorderList(self, head: ListNode) -> None:
    """
    Do not return anything, modify head in-place instead.
    """
    fast = head
    slow = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    prev, curr = None, slow
    while curr:
        curr.next, prev, curr = prev, curr, curr.next

    first, second = head, prev
    while second.next:
        # merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
        first.next, first = second, first.next
        second.next, second = first, second.next
