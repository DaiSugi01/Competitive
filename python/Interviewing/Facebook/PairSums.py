from collections import Counter


def numberOfWays(arr, k):
    res = 0
    c = Counter(arr)
    print(c)
    for n in arr:
        if k - n in c:
            res += c[k-n]
    return res


if __name__ == '__main__':
    arr = [2, 1, 3, 4, 2, 4, 2]
    k = 4
    print(numberOfWays(arr, k))