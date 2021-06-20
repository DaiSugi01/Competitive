# https://leetcode.com/problems/minimum-depth-of-binary-tree/
from LeetCode.utils import TreeNode
import queue


def min_depth(root: TreeNode) -> int:
    if root is None:
        return 0

    q = queue.Queue()
    q.put(root)
    level = 0

    while not q.empty():
        level += 1
        for _ in range(0, q.qsize()):
            node = q.get()
            if node is None:
                continue

            if node.left is None and node.right is None:
                return level
            q.put(node.left)
            q.put(node.right)

    return level
