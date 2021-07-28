# https://leetcode.com/problems/number-of-islands/
from collections import deque
from typing import List


def numIslands(grid: List[List[str]]) -> int:
    m = len(grid)
    n = len(grid[0])

    def bfs(x: int, y: int):
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]

        q = deque([(x, y)])
        while q:
            x, y = q.popleft()
            grid[x][y] = 0

            for i in range(len(dx)):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue

                if grid[nx][ny] == '1':
                    grid[nx][ny] = 0
                    q.append((nx, ny))

    id = 0
    for x in range(m):
        for y in range(n):
            if grid[x][y] == '1':
                bfs(x, y)
                id += 1

    return id