# https://leetcode.com/problems/invert-binary-tree/
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def invertTree(self, root: TreeNode) -> TreeNode:
    if root is None:
        return None

    right: TreeNode = self.invertTree(root.right)
    left: TreeNode = self.invertTree(root.left)
    root.left = right
    root.right = left

    return root
