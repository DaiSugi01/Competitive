# https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
from collections import Counter
from typing import List


class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        #       map the number and count to find out which number is the least
        #       sort the above map by the count asc [2, 4, 1, 1, 3, 3, 3]
        #       return make set(sorted_arr[k:]).length
        dic = Counter(arr)
        sorted_arr = sorted(arr, key=lambda x: (dic[x], x))
        res = set(sorted_arr[k:])

        return len(res)
