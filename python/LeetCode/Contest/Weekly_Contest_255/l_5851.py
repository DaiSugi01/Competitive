from typing import List


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        if len(nums) <= 1:
            return bin(int(nums[0], 2) ^ 1)[2:]

        for i in range(1, 2 ** len(nums)):
            temp = '0' * abs(len(bin(i)[2:]) - len(nums)) + bin(i)[2:]
            if temp not in nums:
                return temp


if __name__ == '__main__':
    t0 = ["10", "11"]
    t1 = ["01", "10"]
    t2 = ["00", "01"]
    t3 = ["111", "011", "001"]
    sol = Solution()
    print(sol.findDifferentBinaryString(t0))
