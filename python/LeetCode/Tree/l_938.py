import  TreeNode
from typing import List
import queue

# https://leetcode.com/problems/range-sum-of-bst/
def rangeSumBST(root: TreeNode, low: int, high: int) -> int:
    if root is None:
        return 0

    sum: int = 0

    sum += rangeSumBST(root.left, low, high)
    sum += rangeSumBST(root.right, low, high)

    if root.val >= low and root.val <= high:
        return sum + root.val
    else:
        return sum
