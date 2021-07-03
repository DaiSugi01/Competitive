# https://projecteuler.net/problem=1
def multiples(num: int) -> int:
    total: int = 0
    for i in range(1, num):
        if i % 3 == 0 or i % 5 == 0:
            total += i

    return total


if __name__ == '__main__':
    print(multiples(1000))
