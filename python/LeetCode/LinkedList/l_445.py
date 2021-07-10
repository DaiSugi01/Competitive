# https://leetcode.com/problems/add-two-numbers-ii/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        def reverse_list(head: ListNode):
            prev: ListNode = None
            curr: ListNode = head

            while curr:
                temp_next: ListNode = curr.next
                curr.next = prev
                prev = curr
                curr = temp_next

            return prev

        l1 = reverse_list(l1)
        l2 = reverse_list(l2)

        head: ListNode = None
        carry: int = 0
        while l1 or l2:
            x1: int = l1.val if l1 else 0
            x2: int = l2.val if l2 else 0

            value: int = (x1 + x2 + carry) % 10
            carry: int = (x1 + x2 + carry) // 10

            curr = ListNode(value)
            curr.next = head
            head = curr

            l1: int = l1.next if l1 else None
            l2: int = l2.next if l2 else None

        if carry:
            curr = ListNode(carry)
            curr.next = head
            head = curr

        return head
