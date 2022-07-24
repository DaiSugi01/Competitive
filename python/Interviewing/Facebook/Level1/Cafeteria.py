from typing import List


def getMaxAdditionalDinersCount(N: int, K: int, M: int, S: List[int]) -> int:
    if not S or N <= 0: return 0
    seats = [True for _ in range(N)]
    for seat_num in S:
        left_seat = seat_num - K - 1 if seat_num - K - 1 >= 0 else 0
        right_seat = seat_num + K if seat_num + K < N else N
        for i in range(left_seat, right_seat):
            seats[i] = False

    ready_seat = 0
    i = 0
    while i < N:
        if seats[i]:
            ready_seat += 1
            i += K + 1
        else:
            i += 1

    return ready_seat


if __name__ == '__main__':
    N = 10
    K = 5
    M = 2
    S = [2, 6]
    # N = 15
    # K = 2
    # M = 3
    # S = [11, 6, 14]
    print(getMaxAdditionalDinersCount(N, K, M, S))
