# https://atcoder.jp/contests/abc210/submissions/24436366
def solution():
    N, A, X, Y = map(int, input().split())
    print(N * X - (X - Y) * max((N - A), 0))


if __name__ == '__main__':
    solution()
