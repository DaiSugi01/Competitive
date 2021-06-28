# https://leetcode.com/problems/intersection-of-two-linked-lists/
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def getIntersectionNode(headA: ListNode, headB: ListNode) -> ListNode:
    while headA:
        target = headB
        while target:
            if headA == target:
                return headA
            target = target.next
        headA = headA.next

    return None
