# https://leetcode.com/problems/add-two-numbers/
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def add_two_numbers(l1: ListNode, l2: ListNode) -> ListNode:
    def add_two_numbers_helper(hl1: ListNode, hl2: ListNode, add: int = 0) -> ListNode:
        if hl1 is None and hl2 is None:
            if add > 0:
                return ListNode(1)
            else:
                return None

        val: int = 0
        if add > 0:
            val += 1

        if hl1 is None:
            val += hl2.val
            if val >= 10:
                add = 1
                val -= 10
            else:
                add = 0
            root = ListNode(val)
            root.next = add_two_numbers_helper(hl1, hl2.next, add)
        elif hl2 is None:
            val += hl1.val
            if val >= 10:
                add = 1
                val -= 10
            else:
                add = 0
            root = ListNode(val)
            root.next = add_two_numbers_helper(hl1.next, hl2, add)
        else:
            val += hl1.val + hl2.val
            if val >= 10:
                add = 1
                val -= 10
            else:
                add = 0

            root = ListNode(val)
            root.next = add_two_numbers_helper(hl1.next, hl2.next, add)

        return root

    node = add_two_numbers_helper(l1, l2)
    return node
