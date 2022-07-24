# https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
from typing import List


def filterRestaurants(restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> \
        List[int]:
    res = []
    for rest in restaurants:
        if rest[3] > maxPrice or rest[4] > maxDistance:
            continue

        if veganFriendly == 1 and rest[2] != 1:
            continue

        res.append(rest)

    res = sorted(res, key=lambda x: (-x[1], -x[0]))

    return [x[0] for x in res]
