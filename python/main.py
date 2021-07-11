from typing import List

# https://leetcode.com/problems/power-of-two/solution/
def isPowerOfTwo(n: int) -> bool:
    if n == 0:
        return False

    return n & (n - 1) == 0


# https://leetcode.com/problems/is-subsequence/
def isSubsequence(self, s: str, t: str) -> bool:
    i: int = 0
    j: int = 0

    while j < len(t) and i < len(s):
        if s[i] == t[j]:
            i += 1
        j += 1

    return i == len(s)

def searchInsert(nums: List[int], target: int) -> int:
    left: int = 0
    right: int = len(nums) - 1

    while left <= right:
        mid: int = (left + right) // 2

        if nums[mid] == target:
            return mid
        elif target > nums[mid]:
            left = mid + 1
        else:
            right = mid - 1

    return left

from itertools import chain
def reverseWords(s: List[str]) -> None:
    """
    Do not return anything, modify s in-place instead.
    """
    def reverse(l: int, r: int):
        while l <= r:
            s[l], s[r] = s[r], s[l]
            l += 1
            r -= 1

    def reverse_each_word():
        length: int = len(s)
        left: int = 0
        right: int = 0

        while left < length:
            if right == length or s[right] == ' ':
                reverse(left, right - 1)
                left = right + 1

            right += 1

    reverse(0, len(s)-1)
    print(s)
    reverse_each_word()

def findLength(nums1: List[int], nums2: List[int]) -> int:
    nums1.sort()
    nums2.sort()
    print(nums1)
    print(nums2)

    # [1, 1, 2, 2, 3]
    # [1, 2, 3, 4, 7]

    res: int = 0
    curr: int = 0
    i: int = 0
    j: int = 0
    while i < len(nums1) and len(nums2):
        if nums1[i] == nums2[j]:
            curr += 1
            i += 1
            j += 1
            continue

        if nums1[i] > nums2[j]:
            j += 1
        else:
            i += 1
        res = max(res, curr)

    return res


def merge_sort(nums: List[int]) -> List[int]:
    if len(nums) <= 1:
        return nums

    mid: int = len(nums) // 2
    left: List[int] = nums[:mid]
    right: List[int] = nums[mid:]

    merge_sort(left)
    merge_sort(right)

    i = j = k = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            nums[k] = left[i]
            i += 1
        else:
            nums[k] = right[j]
            j += 1
        k += 1

    while i < len(left):
        nums[k] = left[i]
        i += 1
        k += 1

    while j < len(right):
        nums[k] = right[j]
        j += 1
        k += 1

    return nums


if __name__ == '__main__':
    # nums1 = [1, 2, 3, 2, 1]
    # nums2 = [3, 2, 1, 4, 7]
    # print(findLength(nums1, nums2))
    import random
    numbers = [random.randint(0, 100) for _ in range(10)]
    print(merge_sort(numbers))
