# https://leetcode.com/problems/max-area-of-island/
from typing import List
import queue


def maxAreaOfIsland(grid: List[List[int]]) -> int:
    visited: List[List[bool]] = [[False] * len(grid[0]) for i in range(len(grid))]
    n = len(grid)
    m = len(grid[0])

    def dfs(x: int, y: int):
        dx: List[int] = [0, 1, 0, -1]
        dy: List[int] = [1, 0, -1, 0]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if ny < 0 or ny >= m or nx < 0 or nx >= n:
                continue

            if visited[nx][ny]:
                continue

            if grid[nx][ny] == 1:
                visited[nx][ny] = True
                dfs(nx, ny)

    total: int = 0
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            if grid[x][y] == 1 and not visited[x][y]:
                dfs(x, y)
                total += 1

    return total


if __name__ == '__main__':
    # grid = [[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    #         [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
    #         [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
    #         [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]]
    grid = [[1,1,0,0,0],
            [1,1,0,0,0],
            [0,0,0,1,1],
            [0,0,0,1,1]]
    print(maxAreaOfIsland(grid))
