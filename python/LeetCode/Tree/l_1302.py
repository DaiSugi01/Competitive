# https://leetcode.com/problems/deepest-leaves-sum/
import queue


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def deepestLeavesSum(root: TreeNode) -> int:
    q = queue.Queue()
    q.put(root)
    depth: int = 0
    nodes = [[] for _ in range(100000)]

    while not q.empty():
        depth += 1
        for _ in range(q.qsize()):
            node: TreeNode = q.get()
            if node.left is not None:
                nodes[depth].append(node.left.val)
                q.put(node.left)
            if node.right is not None:
                nodes[depth].append(node.right.val)
                q.put(node.right)

    return sum(nodes[depth - 1])
