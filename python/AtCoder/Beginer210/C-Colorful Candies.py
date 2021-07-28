# https://atcoder.jp/contests/abc210/submissions/24450665
from collections import defaultdict

def solution():
    n, k = (map(int, input().split()))
    nums = list(map(int, input().split()))

    d = defaultdict(int)
    for i in range(0, k):
        d[nums[i]] += 1

    ans = len(d)
    for i in range(n - k):
        d[nums[i + k]] += 1
        d[nums[i]] -= 1
        if d[nums[i]] == 0: del d[nums[i]]
        ans = max(ans, len(d))

    print(ans)


if __name__ == '__main__':
    solution()
