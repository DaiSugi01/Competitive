# https://leetcode.com/problems/find-leaves-of-binary-tree/
import collections
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def findLeaves(self, root: TreeNode) -> List[List[int]]:
    res: List[int] = collections.defaultdict(list)

    def dfs(node, depth):
        if node is None:
            return depth
        left = dfs(node.left, depth)
        right = dfs(node.right, depth)
        depth = max(left, right)
        res[depth].append(node.val)
        return depth + 1

    dfs(root, 0)
    return res.values()
