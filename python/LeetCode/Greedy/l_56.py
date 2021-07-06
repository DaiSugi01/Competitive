# https://leetcode.com/problems/merge-intervals/
from typing import List


def merge(intervals: List[List[int]]) -> List[List[int]]:
    intervals.sort(key=lambda x: x[0])

    res: List[List[int]] = []
    for interval in intervals:
        if not res or res[-1][1] < interval[0]:
            res.append(interval)
        else:
            res[-1][1] = max(res[-1][1], interval[1])

    return res


if __name__ == '__main__':
    inter = [[1, 3], [2, 6], [8, 10], [15, 18]]
    merge(inter)
