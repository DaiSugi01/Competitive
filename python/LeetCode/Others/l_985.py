# https://leetcode.com/problems/sum-of-even-numbers-after-queries/
from typing import List


def sum_even_after_queries(A: List[int], queries: List[List[int]]) -> List[int]:

    total = sum(x for x in A if x % 2 == 0)
    res = []

    for val, index in queries:
        if A[index] % 2 == 0:
            total -= A[index]
        A[index] += val
        if A[index] % 2 == 0:
            total += A[index]
        res.append(total)

    return res
