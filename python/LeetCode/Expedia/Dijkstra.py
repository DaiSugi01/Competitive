import heapq
from typing import List

def findCheapestPrice(n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:

    # make a adjacency list
    adj_matrix = [[0 for _ in range(n)] for _ in range(n)]
    for s, d, w in flights:
        adj_matrix[s][d] = w

    # Shortest distances array
    distances = [float("inf") for _ in range(n)]
    current_stops = [float("inf") for _ in range(n)]
    distances[src], current_stops[src] = 0, 0

    # Data is (cost, stops, node)
    minHeap = [(0, 0, src)]

    while minHeap:

        cost, stops, node = heapq.heappop(minHeap)

        # If destination is reached, return the cost to get here
        if node == dst:
            return cost

        # If there are no more steps left, continue
        if stops == K + 1:
            continue

        # Examine and relax all neighboring edges if possible
        for nei in range(n):
            if adj_matrix[node][nei] > 0:
                dU, dV, wUV = cost, distances[nei], adj_matrix[node][nei]

                # Better cost?
                if dU + wUV < dV:
                    distances[nei] = dU + wUV
                    heapq.heappush(minHeap, (dU + wUV, stops + 1, nei))
                elif stops < current_stops[nei]:
                    #  Better steps?
                    heapq.heappush(minHeap, (dU + wUV, stops + 1, nei))

                current_stops[nei] = stops
    print(current_stops)
    return -1 if distances[dst] == float("inf") else distances[dst]


if __name__ == '__main__':
    n = 3
    flights = [[0, 1, 100], [1, 2, 100], [0, 2, 500]]
    src = 0
    dst = 2
    k = 1
    print(findCheapestPrice(n, flights, src, dst, k))