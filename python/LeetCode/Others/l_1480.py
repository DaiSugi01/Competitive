# https://leetcode.com/problems/running-sum-of-1d-array/
from typing import List


def runningSum(nums: List[int]) -> List[int]:
    if not nums:
        return []

    res: List[int] = []
    res.append(nums[0])

    for i in range(1, len(nums)):
        res.append(res[i - 1] + nums[i])

    return res


if __name__ == '__main__':
    print(runningSum([1, 2, 3, 4]))
