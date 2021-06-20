# https://leetcode.com/problems/minimum-height-trees/
from typing import List

def find_min_height_trees(n: int, edges: List[List[int]]) -> List[int]:
    if n <= 2:
        return [i for i in range(n)]

    adj: [[set]] = [[] for _ in range(0, n)]

    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)

    leaves: [int] = []
    for i in range(n):
        if len(adj[i]) == 1:
            leaves.append(i)

    remaining_nodes = n
    while remaining_nodes > 2:
        remaining_nodes -= len(leaves)
        new_leaves: [int] = []

        while leaves:
            leaf = leaves.pop()
            neighbor = adj[leaf].pop()
            adj[neighbor].remove(leaf)
            if len(adj[neighbor]) == 1:
                new_leaves.append(neighbor)

        leaves = new_leaves

    return leaves
