import math
from typing import List


class Solution:
    def findGCD(self, nums: List[int]) -> int:
        small = min(nums)
        large = max(nums)
        return math.gcd(small, large)


if __name__ == '__main__':
    nums = [2, 5, 6, 9, 10]
    sol = Solution()
    print(sol.findGCD())
