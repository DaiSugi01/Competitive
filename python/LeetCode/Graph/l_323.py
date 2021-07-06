# https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
from typing import List
import queue


def countComponents(n: int, edges: List[List[int]]) -> int:
    def dfs(adj: List[List[int]], w: int):
        if visited[w]:
            return None

        visited[w] = True
        for vertex in adj[w]:
            dfs(adj, vertex)

    adj: List[List[int]] = [[] for _ in range(n)]

    for w, v in edges:
        adj[w].append(v)
        adj[v].append(w)

    visited: List[bool] = [False] * n
    total: int = 0

    for i in range(n):
        if not visited[i]:
            dfs(adj, i)
            total += 1

    return total


if __name__ == '__main__':
    n = 5
    edges = [[0, 1], [1, 2], [3, 4]]
    countComponents(n, edges)
