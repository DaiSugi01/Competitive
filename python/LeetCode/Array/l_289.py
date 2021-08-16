# # https://leetcode.com/problems/game-of-life/
from collections import deque
from typing import List
import copy

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        temp_board = copy.deepcopy(board)

        m = len(board)
        n = len(board[0])

        q = deque()
        dx = [0, 1, 1, 1, 0, -1, -1, -1]
        dy = [1, 1, 0, -1, -1, -1, 0, 1]
        visited = [[False] * n for _ in range(m)]

        print('*******before*************:')
        for i in range(len(board)):
            print(board[i])

        def bfs(x: int, y: int):
            q.append((x, y))
            while q:
                cx, cy = q.popleft()
                visited[cy][cx] = True
                total = 0
                live_count = 0
                # [0, 1, 0]
                # [0, 0, 1]
                # [1, 1, 1]
                # [0, 0, 0]
                for i in range(8):
                    nx = cx + dx[i]
                    ny = cy + dy[i]

                    if nx < 0 or nx >= n or ny < 0 or ny >= m:
                        continue

                    live_count += 1 if board[ny][nx] == 1 else 0
                    total += 1

                    if not visited[ny][nx]:
                        q.append((nx, ny))

                # live <= 2 ... turn into 0
                # live 2 or 3 ... turn into 1
                # live > 3 ... turn into 0
                # dead == 3 ... turn into 1
                if board[cy][cx] == 1:
                    if live_count < 2 or live_count > 3:
                        temp_board[cy][cx] = 0
                    elif live_count == 2 or live_count == 3:
                        temp_board[cy][cx] = 1
                    else:
                        pass
                else:
                    if total - live_count == 3:
                        temp_board[cy][cx] = 1
                    elif live_count == 2 or live_count == 3:
                        temp_board[cy][cx] = 1

                    res = 0

        bfs(0, 0)
        print('*******temp_board*********:')
        for i in range(len(temp_board)):
            print(temp_board[i])


if __name__ == '__main__':
    s = Solution()
    board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    s.gameOfLife(board)
