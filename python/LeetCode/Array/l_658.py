# https://leetcode.com/problems/find-k-closest-elements
from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        temp = [(abs((arr[i] * -1) - -x), i) for i in range(len(arr))]
        temp.sort()

        res = [arr[temp[i][1]] for i in range(k)]
        res.sort()

        return res


if __name__ == '__main__':
    sol = Solution()
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = -1
    print(sol.findClosestElements(arr, k, x))
