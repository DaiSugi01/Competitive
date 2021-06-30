# https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sumEvenGrandparent(self, root: TreeNode) -> int:
    total: int = 0

    def helper(node: TreeNode, node_list: List[int]):
        if node is None:
            return

        nonlocal total

        node_list.append(node.val)
        helper(node.left, node_list)
        helper(node.right, node_list)
        if len(node_list) > 2 and node_list[len(node_list) - 3] % 2 == 0:
            total += node.val

        node_list.pop()

    helper(root, [])

    return total
