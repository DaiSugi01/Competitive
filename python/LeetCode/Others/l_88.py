# https://leetcode.com/problems/merge-sorted-array/
from typing import List


def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    """
    Do not return anything, modify nums1 in-place instead.
    """
    n -= 1
    m -= 1
    k = len(nums1) - 1
    while n >= 0 and m >= 0:
        if nums2[n] >= nums1[m]:
            nums1[k] = nums2[n]
            n -= 1
        else:
            nums1[k] = nums1[m]
            m -= 1
        k -= 1

    while k >= 0:
        if n >= 0:
            nums1[k] = nums2[n]
            n -= 1
        else:
            nums1[k] = nums1[m]
            m -= 1
        k -= 1
