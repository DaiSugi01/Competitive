# https://leetcode.com/problems/minimize-product-sum-of-two-arrays/
from typing import List


def minProductSum(self, nums1: List[int], nums2: List[int]) -> int:
    nums1.sort()
    nums2.sort()

    res: int = 0
    i: int = 0
    j: int = len(nums2) - 1
    while i < len(nums1):
        res += nums1[i] * nums2[j]
        i += 1
        j -= 1

    return res