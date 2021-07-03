# https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
import queue


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def get_height(depth: int, root: TreeNode):
    q = queue.Queue()
    q.put(root)
    depth = 0
    while not q.empty():
        for _ in range(q.qsize()):
            node = q.get()
            if node.left is not None:
                q.put(node.left)
            if node.right is not None:
                q.put(node.right)

        depth += 1

    return depth - 1


if __name__ == '__main__':
    root: TreeNode = TreeNode(3)

    root.left = TreeNode(2)
    root.left.left = TreeNode(1)

    root.right = TreeNode(5)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(6)
    root.right.right.right = TreeNode(7)

    print(get_height(0, root))

