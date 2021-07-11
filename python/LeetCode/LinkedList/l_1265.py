# https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
class ImmutableListNode:
    def printValue(self) -> None: # print the value of this node.
        pass

    def getNext(self) -> 'ImmutableListNode': # return the next node.
        pass


def printLinkedListInReverse(head: 'ImmutableListNode') -> None:
    res = []
    curr = head

    while curr:
        res.append(curr)
        curr = ImmutableListNode.getNext(curr)

    res.reverse()
    for i in res:
        ImmutableListNode.printValue(i)
