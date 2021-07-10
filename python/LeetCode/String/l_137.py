# https://leetcode.com/problems/single-number-ii/
from collections import Counter
from typing import Dict, List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        dic: Dict = Counter(nums)

        return min(dic.items(), key=lambda x: x[1])[0]
