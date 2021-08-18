# https://leetcode.com/problems/lonely-pixel-i/
from collections import List


class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        m = len(picture)
        n = len(picture[0])
        visited = [[False] * n for _ in range(m)]

        def check(x, y) -> bool:
            for i in range(m):
                visited[i][y] = True
                if i == x: continue
                if picture[i][y] == 'B': return False

            for i in range(n):
                visited[x][i] = True
                if i == y: continue
                if picture[x][i] == 'B': return False

            return True

        res = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and picture[i][j] == 'B':
                    visited[i][j] = True
                    if check(i, j):
                        res += 1

        return res


if __name__ == '__main__':
    picture = [["W", "W", "B"], ["W", "B", "W"], ["B", "W", "W"]]
    sol = Solution()
    sol.findLonelyPixel(picture)
