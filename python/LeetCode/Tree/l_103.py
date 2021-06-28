# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
import queue
from typing import List
from LeetCode.utils import TreeNode


def zigzag_level_order(root: TreeNode) -> List[List[int]]:
    if root is None:
        return []
    res: List[List[int]] = [[root.val]]
    is_reverse: bool = True

    q = queue.Queue()
    q.put(root)
    while not q.empty():
        temp: [int] = []
        for i in range(q.qsize()):
            node: TreeNode = q.get()
            if node.left is not None:
                q.put(node.left)
                temp.append(node.left.val)

            if node.right is not None:
                q.put(node.right)
                temp.append(node.right.val)

        if not temp:
            continue
        if is_reverse:
            temp.reverse()

        res.append(temp)
        is_reverse = not is_reverse

    return res
