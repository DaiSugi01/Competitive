# https://leetcode.com/problems/word-search/
from typing import List


def exist(board: List[List[str]], word: str) -> bool:
    m = len(board)
    n = len(board[0])
    visited = [[False] * n for _ in range(m)]

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    def dfs(x: int, y: int, word_cnt: int):
        if word_cnt == len(word):
            return True

        visited[x][y] = True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= m or nx < 0 or ny >= n or ny < 0: continue
            if visited[nx][ny]: continue
            if board[nx][ny] != word[word_cnt]: continue

            if dfs(nx, ny, word_cnt + 1):
                return True

        visited[x][y] = False
        return False

    for i in range(m):
        for j in range(n):
            if visited[i][j] or word[0] != board[i][j]: continue
            if dfs(i, j, 1):
                return True

    return False


if __name__ == '__main__':
    board = [["C", "A", "A"], ["A", "A", "A"], ["B", "C", "D"]]
    word = "AAB"
    print(word)
    for i in board:
        print(i)
    print(exist(board, word))
