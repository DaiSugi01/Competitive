# https://leetcode.com/problems/flood-fill/
from typing import List


def flood_fill(image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]

    color = image[sr][sc]
    if color == newColor:
        return image

    r = len(image)
    c = len(image[0])

    def dfs(y: int, x: int):
        image[y][x] = newColor

        for i in range(0, 4):
            ny = dy[i] + y
            nx = dx[i] + x

            if ny < 0 or ny >= r or nx < 0 or nx >= c:
                continue

            if image[ny][nx] == color:
                dfs(ny, nx)

    dfs(sr, sc)

    return image
