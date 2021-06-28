# https://leetcode.com/problems/odd-even-linked-list/
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def oddEvenList(head: ListNode) -> ListNode:
    if head is None:
        return

    odd_list: ListNode = ListNode()
    odd_head = odd_list
    even_list: ListNode = ListNode()
    even_head = even_list
    cnt: int = 1

    while head:
        if cnt % 2 == 0:
            new_node = ListNode(head.val)
            even_list.next = new_node
            even_list = even_list.next
        else:
            new_node = ListNode(head.val)
            odd_list.next = new_node
            odd_list = odd_list.next

        cnt += 1
        head = head.next

    odd_list.next = even_head.next

    return odd_head.next
