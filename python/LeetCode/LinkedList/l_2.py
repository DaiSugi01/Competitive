# https://leetcode.com/problems/add-two-numbers/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def add_two_numbers(l1: ListNode, l2: ListNode) -> ListNode:
    new_l = ListNode()
    curr = new_l
    new_l.next = curr
    carry: int = 0

    while l1 or l2:
        x1: int = l1.val if l1 else 0
        x2: int = l2.val if l2 else 0

        value: int = (x1 + x2 + carry) % 10
        carry: int = (x1 + x2 + carry) // 10

        curr.next = ListNode(value)
        curr = curr.next

        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None

    if carry:
        curr.next = ListNode(carry)

    return new_l.next
