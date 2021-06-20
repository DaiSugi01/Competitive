# https://leetcode.com/problems/binary-tree-inorder-traversal/
from LeetCode.utils import TreeNode
from typing import List


def inorder_traversal(root: TreeNode) -> List[int]:

    res: List[int] = []

    def inorder_traversal_helper(node: TreeNode) -> List[int]:
        if node is None:
            return None

        inorder_traversal_helper(node.left)
        res.append(node.val)
        inorder_traversal_helper(node.right)

    inorder_traversal_helper(root)

    return res

