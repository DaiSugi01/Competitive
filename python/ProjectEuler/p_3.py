# https://projecteuler.net/problem=3
from typing import List


def prime_factorization(n) -> List[int]:
    l: List[int] = []

    for i in range(2, int(n**0.5)):
        while True:
            if n % i == 0:
                n = n // i
                l.append(i)
            else:
                break

    if n != 1:
        l.append(i)

    return l


if __name__ == '__main__':
    n = 600851475143
    print(prime_factorization(n))
