# https://leetcode.com/problems/binary-tree-level-order-traversal/
from typing import List
from LeetCode.utils import TreeNode
import queue

def level_order(root: TreeNode) -> List[List[int]]:
    q = queue.Queue()
    q.put(root)
    level = 0
    res: [[int]] = []

    while not q.empty():

        res.append([])
        for _ in range(0, q.qsize()):
            node = q.get()
            if node is None:
                continue

            res[level].append(node.val)
            if node.left is not None:
                q.put(node.left)
            if node.right is not None:
                q.put(node.right)

        level += 1

    return res

