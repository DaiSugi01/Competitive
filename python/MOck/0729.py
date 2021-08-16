# Given an integer array nums of unique elements, return all possible subsets (the power set).
# The solution set must not contain duplicate subsets. Return the solution in any order.
# Input: nums = [1,2,3]
# Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]  - 8
# Input: nums = [1, 2]
# Output: [[],[1], [2], [1, 2]]  - 4
# Input: nums = [0]
# Output: [[],[0]]  - 2

# # of subsets = 2^n

from typing import List

def subsets1(nums: List[int]) -> List[List[int]]:
    # 2 ** n
    # j < len(nums)
    j = 0
    res = [[]]
    for i in range(len(nums)):
        j = i
        while j < len(nums):
            if i == j:
                res.append([nums[i]])
            else:
                res.append([nums[i], nums[j]])
                new = sorted([num for num in nums[i:j+1]], key=lambda x: x)
                if new not in res:
                    res.append(new)
            j += 1

    return res

# nums = [1, 2, 3]
# res = [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
# 1
# n * 2^n
def subsets2(nums: List[int]) -> List[List[int]]:
    res = [[]]
    for i in nums:  # n
        for sub in res.copy():  # 2^n
            res += [sub + [i]]

    return res


def subsets3(nums: List[int]) -> List[List[int]]:
    def calc(subset: [int], start: int):
        if len(subset) == 1:
            res.append(subset[:])
            return

        for i in range(start, len(nums)):
            subset.append(nums[i])
            calc(subset, i + 1)
            subset.pop()

    res = []
    for base in range(0, len(nums) + 1):
        calc([], 0)

    return res

# Time : n * 2^n
# Space : n


if __name__ == '__main__':
    nums = [1, 2, 3]
    print(subsets1(nums))
    print(subsets2(nums))
    print(subsets3(nums))
