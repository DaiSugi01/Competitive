# https://leetcode.com/problems/number-of-islands/
from typing import List
import queue

def num_islands(grid: List[List[str]]) -> int:
    m = len(grid)
    n = len(grid[0])

    colored_map: [[int]] = [[0] * n for _ in range(0, m)]

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    def bfs(x: int, y: int, cnt: int):
        q = queue.Queue()
        q.put((x, y))

        while not q.empty():
            x, y = q.get()
            for i in range(0, len(dx)):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue

                if colored_map[nx][ny] == 0 and grid[nx][ny] == "1":
                    colored_map[nx][ny] = cnt
                    q.put((nx, ny))

    cnt: int = 0
    for x in range(0, m):
        for y in range(0, n):
            if grid[x][y] == "1" and colored_map[x][y] == 0:
                cnt += 1
                colored_map[x][y] = cnt
                bfs(x, y, cnt)

    return cnt
