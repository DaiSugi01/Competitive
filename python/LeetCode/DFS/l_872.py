# https://leetcode.com/problems/leaf-similar-trees/
from typing import List
from LeetCode import TreeNode


def leaf_similar(root1: TreeNode, root2: TreeNode) -> bool:

    def dfs(node: TreeNode, arr: [int]) -> List[int]:
        if arr is None:
            arr = []

        if node is None:
            return arr

        if node.left is None and node.right is None:
            arr.append(node.val)

        dfs(node.left, arr)
        dfs(node.right, arr)

        return arr

    res1: [int] = dfs(root1, [])
    res2: [int] = dfs(root2, [])

    return res1 == res2
