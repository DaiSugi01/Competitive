# https://www.geeksforgeeks.org/expedia-coding-round-experience-intern-2021/
from collections import Counter


def dist_ids(arr, m) -> str:
    dic = Counter(arr)
    sorted_arr = sorted(arr, key=lambda x: dic[x])

    s = set(sorted_arr[m:])
    return len(s)


if __name__ == '__main__':
    # output: 1
    # arr = [2, 2, 1, 3, 3, 3]
    arr = [2, 4, 1, 5, 3, 5, 1, 3]
    m = 3
    print(dist_ids(arr, m))
