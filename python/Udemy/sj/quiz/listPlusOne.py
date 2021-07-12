from typing import List


def list_to_int(num: List[int]) -> int:
    sum_nums = 0
    for i, n in enumerate(reversed(num)):
        sum_nums += n * (10**i)

    return sum_nums + 1


def list_plus_one(num: List[int]) -> int:

    def remove_zero(num: List[int]):
        if num and num[0] == 0:
            num.pop(0)
            remove_zero(num)

    remove_zero(num)

    i = len(num) - 1
    num[i] += 1
    while 0 < i:
        if num[i] != 10:
            break

        num[i] = 0
        num[i - 1] += 1
        i -= 1

    if num[0] >= 10:
        num[0] = 1
        num.append(0)

    return num


if __name__ == '__main__':
    # n = [1]
    # n = [2, 3]
    # n = [0, 9, 9]
    n = [0,0,0,9, 9, 9, 9]
    print(list_plus_one(n))
    print(list_to_int(n))
