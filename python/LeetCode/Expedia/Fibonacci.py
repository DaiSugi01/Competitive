def fibonacci(n, memo):
    if n <= 2:
        return 1

    if n in memo:
        return memo[n]

    memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
    return memo[n]


if __name__ == '__main__':
    dp ={}
    print(fibonacci(10, dp))
