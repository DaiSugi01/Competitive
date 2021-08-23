from typing import List


class Solution:
    def minimizeTheDifference(self, mat, target):
        nums = {0}
        for row in mat:
            nums = {x + i for x in row for i in nums}

        return min(abs(target - x) for x in nums)


if __name__ == '__main__':
    mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    target = 13
    sol = Solution()
    print(sol.minimizeTheDifference(mat, target))
