# https://leetcode.com/problems/increasing-order-search-tree/
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def increasingBST(root: TreeNode) -> TreeNode:
    seq_nums: List[int] = []

    def inorder(node: TreeNode):
        if node is None:
            return None

        inorder(node.left)
        seq_nums.append(node.val)
        inorder(node.right)

    def construct_new_tree(node: TreeNode) -> TreeNode:
        if not seq_nums:
            return node

        node.right = construct_new_tree(TreeNode(seq_nums.pop(0)))

        return node

    inorder(root)

    return construct_new_tree(TreeNode(seq_nums.pop(0)))
