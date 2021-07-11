# https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def deleteNodes(head: ListNode, m: int, n: int) -> ListNode:
    curr: ListNode = head
    last: ListNode = head

    while curr:
        m_count: int = m
        n_count: int = n
        while curr and m_count > 0:
            last = curr
            m_count -= 1
            curr = curr.next

        while curr and n_count > 0:
            curr = curr.next
            n_count -= 1

        last.next = curr

    return head
