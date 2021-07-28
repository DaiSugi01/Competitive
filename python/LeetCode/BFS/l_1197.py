# https://leetcode.com/problems/number-of-islands/
from collections import deque
from functools import lru_cache
from typing import Tuple


def minKnightMoves(x: int, y: int) -> int:

    @lru_cache(maxsize=None)
    def dfs(x: int, y: int):
        if x + y == 0:
            return 0
        elif x + y == 2:
            return 2
        else:
            return min(dfs(abs(x - 1), abs(y - 2)), dfs(abs(x - 2), abs(y - 1))) + 1

    return dfs(abs(x), abs(y))

    # def bfs(cx, cy, cnt) -> Tuple[int, int]:
    #     if cx == x and cy == y:
    #         return cnt
    #
    #     visited = set()
    #     visited.add((cx, cy))
    #     dx = [1, 2, 2, 1, -1, -2, -2, -1]
    #     dy = [2, 1, -1, -2, -2, -1, 1, 2]
    #
    #     q = deque([(cx, cy, cnt + 1)])
    #
    #     while q:
    #         cx, cy, cnt = q.popleft()
    #
    #         for i in range(len(dx)):
    #             nx = cx + dx[i]
    #             ny = cy + dy[i]
    #
    #             if nx == x and ny == y:
    #                 return cnt
    #
    #             if (nx, ny) not in visited:
    #                 visited.add((nx, ny))
    #                 q.append((nx, ny, cnt + 1))
    #
    # return bfs(0, 0, 0)
