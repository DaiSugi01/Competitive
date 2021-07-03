# https://projecteuler.net/problem=4
def is_palindrome(n: int) -> bool:
    s = str(n)
    i: int = 0
    j: int = len(s) - 1
    while i < j:
        if s[i] != s[j]:
            return False

        i += 1
        j -= 1

    return True


def largest_palindrome_product(digit: int) -> int:
    n: int = int('1' + '0' * digit)
    m = 0
    for i in reversed(range(n // 10, n)):
        for j in reversed(range(2, i)):
            total: int = i * j
            if is_palindrome(total):
                m = max(total, m)
                continue

    return m


if __name__ == '__main__':
    print(largest_palindrome_product(3))
