# https://leetcode.com/problems/degree-of-an-array/
from collections import defaultdict
from typing import List


class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        left, right = {}, {}
        counter = defaultdict(int)

        for i, num in enumerate(nums):
            if num not in left: left[num] = i
            right[num] = i
            counter[num] += 1

        degree = max(counter.values())
        res = len(nums)
        for i in counter:
            if counter[i] == degree:
                res = min(res, right[i] - left[i] + 1)

        return res
