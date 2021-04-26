# https://leetcode.com/problems/reverse-integer/
def reverse(x: int) -> int:
    is_neg = False
    if x < 0:
        x *= -1
        is_neg = True

    stack: [int] = []
    while x / 10 > 0:
        rest = x % 10
        x = int(x / 10)
        stack.append(rest)

    dig = 1
    sum = 0
    while stack:
        sum += stack.pop(-1) * dig
        dig *= 10

    if is_neg:
        sum *= -1

    if sum > pow(2, 31) - 1 or sum < pow(2, 31) * -1:
        return 0

    return sum