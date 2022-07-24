# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""


class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        # find the depth of both p and q
        # level up deeper node until both p and q are the same level
        # level up until both p and q reach the same node

        def get_depth(node: 'Node'):
            depth = 0
            while node:
                node = node.parent
                depth += 1
            return depth

        p_depth = get_depth(p)
        q_depth = get_depth(q)

        for i in range(p_depth - q_depth):
            p = p.parent

        for i in range(q_depth - p_depth):
            q = q.parent

        while p != q:
            p = p.parent
            q = q.parent

        return p
