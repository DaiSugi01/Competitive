from typing import List
import heapq

class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        piles = list(map(lambda x: x * -1, piles))
        heapq.heapify(piles)

        for _ in range(k):
            temp = heapq.heappop(piles) * -1
            reducer = temp // 2
            new_num = temp - reducer
            heapq.heappush(piles, new_num * -1)

        return sum(piles) * -1


if __name__ == '__main__':
    sol = Solution()
    piles = [5, 4, 9]
    k = 2
    # piles = [4,3,6,7]
    # k = 3
    print(sol.minStoneSum(piles, k))
