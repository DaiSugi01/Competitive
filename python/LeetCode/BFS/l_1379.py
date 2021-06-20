# https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
from LeetCode.utils import TreeNode


def get_target_copy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
    def dfs(c: TreeNode, t: TreeNode) -> TreeNode:
        if c is None:
            return None

        if c.val == t.val:
            return c

        node = TreeNode(0)
        node.left = dfs(c.left, t)
        if node.left is not None:
            return node.left

        node.right = dfs(c.right, t)

        if node.right is not None:
            return node.right

        return None

    return dfs(cloned, target)
