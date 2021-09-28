# https://leetcode.com/problems/validate-binary-search-tree/
# Definition for a binary tree node.
import math
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def is_valid_tree(node: TreeNode):
            nonlocal prev
            if not node:
                return True

            if not is_valid_tree(node.left):
                return False

            if node.val <= prev:
                return False

            prev = node.val
            return is_valid_tree(node.right)

        prev = -math.inf

        return is_valid_tree(root)
