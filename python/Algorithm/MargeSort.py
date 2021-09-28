from typing import List

# [5, 4, 8, 1]
# left_arr = [5, 4] right_arr = [8, 1] by middle index which is 2
# left_arr = [5] right_arr = [4] by middle index which is 1
# split array until the number of element in the left and right array is 1
# Sort it
# Compare the first element of left array and right array.
# i for tracking the left array position
# j for tracking the right array position
# k for tracking the numbers array position
# if left_arr[i] <= right_arr[j]:
#   numbers[k] = left_arr[i++]
# else:
#   numbers[k] = right_arr[j++]

# left_arr = [4, 5] right_arr = [1, 8] by middle index which is 2
# numbers[1,5,4,1]

def merge_sort(numbers: List[int]) -> List[int]:
    if len(numbers) <= 1:
        return numbers

    mid = len(numbers) // 2
    left_arr = numbers[:mid]
    right_arr = numbers[mid:]

    merge_sort(left_arr)
    merge_sort(right_arr)

    # sort the array
    i = j = k = 0
    while i < len(left_arr) and j < len(right_arr):
        if left_arr[i] <= right_arr[j]:
            numbers[k] = left_arr[i]
            i += 1
        else:
            numbers[k] = right_arr[j]
            j += 1

        k += 1

    while i < len(left_arr):
        numbers[k] = left_arr[i]
        i += 1
        k += 1

    while j < len(right_arr):
        numbers[k] = right_arr[j]
        j += 1
        k += 1

    return numbers


if __name__ == '__main__':
    nums = [5, 4, 1, 8, 7, 3, 2, 9]
    print(merge_sort(nums))
