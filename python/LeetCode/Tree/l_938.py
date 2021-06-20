# https://leetcode.com/problems/range-sum-of-bst/
from LeetCode.utils import TreeNode

def rangeSumBST(root: TreeNode, low: int, high: int) -> int:
    if root is None:
        return 0

    total: int = 0

    total += rangeSumBST(root.left, low, high)
    total += rangeSumBST(root.right, low, high)

    if root.val >= low and root.val <= high:
        return total + root.val
    else:
        return total
