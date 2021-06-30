# https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
from typing import List


def maxProductDifference(self, nums: List[int]) -> int:
    if len(nums) <= 4:
        return []

    nums.sort()
    return nums[len(nums) - 1] * nums[len(nums) - 2] - nums[0] * nums[1]


if __name__ == '__main__':
    maxProductDifference([5,6,2,7,4])
