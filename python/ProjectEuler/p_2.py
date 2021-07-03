# https://projecteuler.net/problem=2
def even_fib(n) -> int:
    dp = [0, 1]
    total: int = 0
    i: int = 2

    while True:
        if dp[i-1] + dp[i-2] > n:
            break

        dp.append(dp[i-1] + dp[i-2])

        if dp[i] % 2 == 0:
            total += dp[i]

        i += 1

    return total


if __name__ == '__main__':
    n: int = 4000000
    print(even_fib(n))
