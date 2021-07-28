# https://leetcode.com/problems/word-search-ii/
from typing import List

def findWords(board: List[List[str]], words: List[str]) -> List[str]:
    res = []
    m = len(board)
    n = len(board[0])
    longest_word = 0
    for word in words:
        longest_word = max(longest_word, len(word))

    visited = [[False] * n for _ in range(m)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    def dfs(x: int, y: int, word_count: int, target: str):
        if word_count > longest_word:
            return False

        if word_count == len(target):
            return True

        visited[x][y] = True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= m or nx < 0 or ny >= n or ny < 0: continue
            if visited[nx][ny]: continue
            if board[nx][ny] != target[word_count]: continue

            if dfs(nx, ny, word_count + 1, target):
                visited[x][y] = False
                return True

        visited[x][y] = False

        return False

    for i in range(m):
        for j in range(n):
            for k in reversed(range(len(words))):
                if board[i][j] != words[k][0]: continue
                if dfs(i, j, 1, words[k]):
                    res.append(words.pop(k))

    return res


if __name__ == '__main__':
    board = [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]]
    words = ["oath", "pea", "eat", "rain", "oathi", "oathk", "oathf", "oate", "oathii", "oathfi", "oathfii"]
    print('words', words)
    for i in board:
        print(i)

    # ["oath", "eat", "hklf", "hf"]
    print(findWords(board, words))
