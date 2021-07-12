from collections import Counter
from typing import List


def min_cournt_remove(x: List[int], y: List[int]) -> None:
    d1 = Counter(x)
    d2 = Counter(y)

    for k, v in d1.items():
        if k not in d2:
            continue

        if v > d2.get(k, 0):
            y[:] = [i for i in y if i != k]
        elif v < d2.get(k, 0):
            x[:] = [i for i in x if i != k]

    print(x)
    print(y)


if __name__ == '__main__':
    x = [1, 2, 3, 4, 4, 5, 5, 8, 10]
    y = [4, 5, 5, 5, 6, 7, 8, 8, 10]
    min_cournt_remove(x, y)
