from typing import List


def max_sub_array_sum(nums: List[int]):
    # dp = [0 for _ in range(len(nums))]
    # dp[0] = nums[0]

    for i in range(1, len(nums)):
        nums[i] = max(nums[i-1] + nums[i], nums[i])

    return nums


if __name__ == '__main__':
    nums = [1, -2, 3, 6, -1, 4, 2, -5, 2]
    print(max_sub_array_sum(nums))
