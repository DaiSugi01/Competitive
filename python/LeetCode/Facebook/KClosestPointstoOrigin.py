# https://leetcode.com/problems/k-closest-points-to-origin/
import heapq
from typing import List
import math


def kClosest(points: List[List[int]], k: int) -> List[List[int]]:
    pq = []
    heapq.heapify(pq)

    for x, y in points:
        sqrt = math.sqrt(x ** 2 + y ** 2)
        heapq.heappush(pq, (sqrt, x, y))

    res = []
    for _ in range(k):
        _, x, y = heapq.heappop(pq)
        res.append([x, y])

    return res
