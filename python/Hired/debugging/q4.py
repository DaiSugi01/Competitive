import typing


def solution(numbers: typing.List[int]) -> int:
    largest_sum = 0
    while len(numbers) > 0:
        previous_number = numbers.pop(0)
        if previous_number == -1:
            return -1

        for number in numbers:
            if number == previous_number - 1:
                sum += number
            else:
                sum = number
            largest_sum = max(largest_sum, sum)
            previous_number = number



    return largest_sum


if __name__ == '__main__':
    numbers = [9, 5, 12, 6, 5, 4, 8]
    print(solution(numbers))
