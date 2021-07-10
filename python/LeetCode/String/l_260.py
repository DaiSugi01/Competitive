# https://leetcode.com/problems/single-number-iii/
from collections import Counter
from typing import List


def singleNumber(nums: List[int]) -> List[int]:
    dic = Counter(nums)
    return [k for k, v in dic.items() if v == 1]
