# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
from typing import List
from LeetCode.utils import TreeNode


def build_tree(preorder: List[int], inorder: List[int]) -> TreeNode:

    def array_to_tree(left: int, right: int):
        nonlocal preorder_index
        if left > right:
            return None

        root_val = preorder[preorder_index]
        root = TreeNode(root_val)

        preorder_index += 1
        root.left = array_to_tree(left, inorder_map[root_val] - 1)
        root.right = array_to_tree(inorder_map[root_val] + 1, right)

        return root

    preorder_index: int = 0
    inorder_map: dict = {}
    for (i, val) in enumerate(inorder):
        inorder_map[val] = i

    return array_to_tree(0, len(preorder) - 1)
