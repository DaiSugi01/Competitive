# https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
from typing import List


class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        memo = []
        for i in range(len(boxes)):
            if boxes[i] == '1':
                memo.append(i)

        res = []
        for i in range(len(boxes)):
            total = 0
            for j in memo:
                total += abs(i - j)

            res.append(total)

        return res


if __name__ == '__main__':
    boxes = "110"
    sol = Solution()
    sol.minOperations(boxes)
