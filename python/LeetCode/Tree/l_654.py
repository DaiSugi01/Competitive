# https://leetcode.com/problems/maximum-binary-tree/
from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def find_max_i(nums: List[int], l: int, r: int) -> int:
    max_i: int = l
    for i in range(l, r):
        if nums[i] > nums[max_i]:
            max_i = i

    return max_i


def constructMaximumBinaryTree(nums: List[int]) -> TreeNode:

    def helper(nums: TreeNode, l: int, r: int):
        if l == r:
            return None
        max_i: int = find_max_i(nums, l, r)
        root = TreeNode(nums[max_i])
        root.left = helper(nums, l, max_i)
        root.right = helper(nums, max_i + 1, r)

        return root

    return helper(nums, 0, len(nums))


if __name__ == '__main__':
    constructMaximumBinaryTree([3, 2, 1, 6, 0, 5])
