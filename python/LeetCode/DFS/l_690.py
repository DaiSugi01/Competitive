# https://leetcode.com/problems/employee-importance/
from typing import List


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


def get_importance(employees: List['Employee'], id: int) -> int:

    adj = [[] for _ in range(0, 2001)]

    for e in employees:
        u = e[0]
        w = e[1]
        adj[u].append((w, e[2]))

    def dfs(*t) -> int:
        em = t[0][0]
        if em[1] is None:
            return w

        total = em[0]
        for v in em[1]:
            total += dfs(adj[v])

        return total

    return dfs(adj[id])
