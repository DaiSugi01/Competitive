# https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
from LeetCode.utils import Node


def maxDepth(root: Node) -> int:

    def dfs(node: Node, cnt: int = 0, mx: int = 0) -> int:
        if node is None:
            return

        for v in node.children:
            mx = max(dfs(v, cnt + 1), mx)

        return mx

    return dfs(root)