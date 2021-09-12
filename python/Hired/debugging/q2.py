import typing


cache = {}
calculations_performed = 0


def factorial(value):
    global cache, calculations_performed
    if value <= 1:
        return value

    cached = cache.get(value)
    if cached:
        return cached

    result = value * factorial(value - 1)
    calculations_performed += 1
    return result


def solution(numbersToCalculate: typing.List[int]) -> typing.List[typing.List[int]]:
    global cache, calculations_performed
    results = []
    for value in numbersToCalculate:
        result = factorial(value)
        results.append([result, calculations_performed])
        calculations_performed = 0

    cache = {}
    return results


if __name__ == '__main__':
    numbersToCalculate = [5, 6, 3]
    print(solution(numbersToCalculate))
