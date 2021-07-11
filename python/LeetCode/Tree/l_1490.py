# https://leetcode.com/problems/clone-n-ary-tree/
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []


class Solution:
    def cloneTree(self, root: 'Node') -> 'Node':
        if root is None:
            return None

        node = Node(root.val)
        for child in root.children:
            node.children.append(self.cloneTree(child))

        return node
