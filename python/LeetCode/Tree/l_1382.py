# https://leetcode.com/problems/balance-a-binary-search-tree/
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def balanceBST(root: TreeNode) -> TreeNode:
    seq_num: List[int] = []

    def inorder(node: TreeNode) -> List[int]:
        if node is None:
            return None

        inorder(node.left)
        seq_num.append(node.val)
        inorder(node.right)

    def arr_to_balaanced_tree(left: int, right: int, nums):
        if left > right:
            return None

        mid: int = (left + right) // 2
        node: TreeNode = TreeNode(nums[mid])

        node.left = arr_to_balaanced_tree(left, mid - 1, nums)
        node.right = arr_to_balaanced_tree(mid + 1, right, nums)

        return node

    inorder(root)
    return arr_to_balaanced_tree(0, len(seq_num) - 1, seq_num)
