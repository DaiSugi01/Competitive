# https://leetcode.com/problems/destination-city/
from collections import defaultdict
from typing import List


def destCity(paths: List[List[str]]) -> str:
    adj_list = defaultdict(list)

    def dfs(origin):
        nonlocal res
        if origin not in adj_list:
            return origin

        while adj_list[origin]:
            dest = adj_list[origin].pop()
            return dfs(dest)

    for origin, to in paths:
        adj_list[origin].append(to)

    return dfs(paths[0][0])
