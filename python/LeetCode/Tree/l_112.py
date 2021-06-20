# https://leetcode.com/problems/path-sum/
from LeetCode.utils import TreeNode


def has_path_sum(root: TreeNode, targetSum: int) -> bool:
    def dfs(node: TreeNode, total: int) -> bool:
        if node is None:
            return False

        total += node.val
        if total == targetSum and node.left is None and node.right is None:
            return True

        is_found_left = dfs(node.left, total)
        is_found_right = dfs(node.right, total)

        return is_found_left or is_found_right

    return dfs(root, 0)
