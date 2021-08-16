# https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        def dfs(node: TreeNode, p: int, length: int) -> int:
            if node is None:
                return length

            length = length + 1 if node.val == p + 1 else 1

            l = dfs(node.left, node.val, length)
            r = dfs(node.right, node.val, length)
            return max(l, r, length)

        return dfs(root, -1, 0)
