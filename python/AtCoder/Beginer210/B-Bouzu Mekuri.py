# https://atcoder.jp/contests/abc210/submissions/24436455
def solution():
    _ = input()
    arr = input()

    idx = arr.index('1')

    if idx % 2 == 0:
        print('Takahashi')
    else:
        print('Aoki')


if __name__ == '__main__':
    solution()
