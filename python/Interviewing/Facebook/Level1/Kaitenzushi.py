from typing import List
from collections import deque

def getMaximumEatenDishCount(N: int, D: List[int], K: int) -> int:
    # loop through the array (use and keep the length of queue to K)
    # if queue size == K, check the next element is the same pattern or not.
    # if the next elements is the same as queue elements, skip next
    # if not, queue.pop()

    q = deque()
    i = 0
    dish = 0
    while i < len(D) and len(D) - i > K:
        if len(q) < K:
            q.append(D[i])
            i += 1
            dish += 1
            continue
        is_found = False
        for j in range(K):
            if q[j] == D[j + i]:
                i += K
                is_found = True
                break
        if not is_found:
            q.popleft()
            q.append(D[i])
            i += 1
            dish += 1

    if i < len(D):
        dish += len(D) - i - 1

    return dish


if __name__ == '__main__':
    # N = 6
    # D = [1, 2, 3, 3, 2, 1]
    # K = 1
    # Expected Return Value = 5
    # N = 6
    # D = [1, 2, 3, 3, 2, 1]
    # K = 2
    # Expected Return Value = 4
    N = 7
    D = [1, 2, 1, 2, 1, 2, 1]
    K = 2
    # Expected Return Value = 2
    print(getMaximumEatenDishCount(N, D, K))
