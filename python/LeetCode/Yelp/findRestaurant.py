# https://leetcode.com/problems/minimum-index-sum-of-two-lists/
from typing import List


def findRestaurant(list1: List[str], list2: List[str]) -> List[str]:
    # I want to map the restaurant name of list1: index of list1 { KFC: 0, Shogun: 1 }
    # I want to loop through the list2
    # if the restaurant name of list 2 is not in the map, continue
    # if it's in the map and the list1 idx + list2 idx == min_sum, push the restaurant to result array
    # if it's in the map and the list1 idx + list2 idx < min_sum, clear the result array and push the restaurant to it
    indices = {}

    for i, key in enumerate(list1):
        indices[key] = i

    min_sum = 10000000
    res = []
    j = 0
    while j < len(list2) and j <= min_sum:
        if list2[j] not in indices:
            j += 1
            continue

        total = j + indices[list2[j]]
        if total == min_sum:
            res.append(list2[j])
        elif total < min_sum:
            res.clear()
            res.append(list2[j])
            min_sum = total

        j += 1

    return res
