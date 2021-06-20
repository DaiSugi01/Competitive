from typing import List

# https://leetcode.com/problems/search-in-rotated-sorted-array/
def search(nums: List[int], target: int) -> int:
    k = nums[0]
    nums.sort()

    def binary_search(l: int, r: int, t: int):
        if l >= r:
            if r < len(nums) and nums[r] == t:
                return r
            else:
                return -1

        mid: int = int((l + r) / 2)
        if nums[mid] == t:
            return mid
        elif t < nums[mid]:
            return binary_search(l, mid - 1, t)
        else:
            return binary_search(mid + 1, r, t)

    res = binary_search(0, len(nums), target)
    if res < 0:
        return -1
    else:
        if min(nums) == k:
            return res
        else:
            if k - len(nums) + res >= 0:
                return k - len(nums) + res
            else:
                return res + k