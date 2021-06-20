from LeetCode.utils import TreeNode


def maximum_average_subtree(node: TreeNode) -> int:

    def dfs(root: TreeNode) -> int:
        if root is None:
            return 0
        cnt: int = 1
        total = root.val
        total += dfs(root.left)
        total += dfs(root.right)
        cnt += 1

        return total

    res = dfs(node)

    return res
