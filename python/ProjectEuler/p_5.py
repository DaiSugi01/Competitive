# https://projecteuler.net/problem=5
import numpy as np


def prime_generator(n: int) -> int:
    """
    n以下の素数を返すgenerator
    :param n: int
    :return: int
    """
    num_arr = np.arange(2, n + 1)
    while num_arr.size > 0:
        prime = num_arr[0]
        yield prime
        num_arr = num_arr[num_arr % prime != 0]


def smallest_multiple(n: int) -> int:
    ans = 1
    for prime in prime_generator(n):
        i = 1
        while prime ** i <= n:
            ans *= prime
            i += 1

    return ans


if __name__ == '__main__':
    print(smallest_multiple(20))
