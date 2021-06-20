# https://leetcode.com/problems/clone-graph/
from LeetCode.utils import Node


def clone_graph(node: Node) -> Node:
    visited: {int: Node} = {}

    def dfs(root: Node) -> Node:
        if root is None:
            return

        if root.val in visited:
            return visited.get(root.val)

        new_node = Node(root.val)
        visited[root.val] = new_node

        for v in root.neighbors:
            new_node.neighbors.append(dfs(v))

        return new_node

    return dfs(node)
