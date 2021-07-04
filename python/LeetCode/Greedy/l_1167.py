from typing import List
import heapq

def connectSticks(sticks: List[int]) -> int:
    heapq.heapify(sticks)
    min_cost: int = 0

    while len(sticks) >= 2:
        first: int = heapq.heappop(sticks)
        second: int = heapq.heappop(sticks)
        combined: int = first + second
        min_cost += combined
        heapq.heappush(sticks, combined)

    return min_cost


if __name__ == '__main__':
    print(connectSticks([2, 4, 3]))
