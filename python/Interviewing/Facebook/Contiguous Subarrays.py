from collections import defaultdict


def count_subarrays(arr):
    if arr is None: return None
    if len(arr) <= 1: return arr

    memo = [1 for _ in range(len(arr))]
    n = len(arr)
    for i in range(1, n):
        if arr[0] < arr[i]:
            break
        memo[0] += 1

    max_val = max(arr)
    left = 1
    right = 2
    while left < right < n:
        if right == n - 1:
            if arr[left] > arr[left - 1]:
                memo[left] = memo[left - 1] + right - left
            else:
                memo[left] = right - left
            if arr[left] > arr[right]:
                memo[left] += 1
            left += 1
            right = left + 1
            continue

        if arr[left] < arr[right]:
            if arr[left] > arr[left - 1]:
                memo[left] = memo[left - 1] + right - left
            else:
                memo[left] = right - left
            left += 1

        if arr[left] > arr[right] or right == left:
            right += 1

    memo[n-1] = memo[n-1] + 1 if arr[n-1] > arr[n-2] else 1
    return memo


if __name__ == '__main__':
    # arr    = [2, 4, 7, 1, 5, 3]
    # output = [1, 2, 6, 1, 3, 1]
    arr = [3, 4, 1, 6, 2]
    output = [1, 3, 1, 5, 1]
    # output = [1, 3, 1, 5, 1]
    # arr    = [2, 4, 7, 1, 7, 3]
    # output = [1, 2, 6, 1, 3, 1]
    print(count_subarrays(arr))
