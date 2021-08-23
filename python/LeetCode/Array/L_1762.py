# https://leetcode.com/problems/buildings-with-an-ocean-view/
from typing import List


class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        stack = []
        for i in reversed(range(len(heights))):
            if not stack:
                stack.append((i, heights[i]))
            elif heights[i] > stack[-1][1]:
                stack.append((i, heights[i]))

        # return reversed(list(map(lambda x: x[0], stack)))
        return reversed([x[1] for x in stack])


if __name__ == '__main__':
    heights = [4, 2, 3, 1]
    sol = Solution()
    sol.findBuildings(heights)
