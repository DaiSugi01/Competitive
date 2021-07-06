# https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
from typing import List


def minRemoveToMakeValid(s: str) -> str:
    stack: List[int] = []
    close_p: List[int] = []

    for i, c in enumerate(s):
        if c == '(':
            stack.append(i)
        elif c == ')':
            if stack:
                stack.pop()
            else:
                close_p.append(i)

    s = list(s)
    while stack:
        s.pop(stack.pop())

    while close_p:
        s.pop(close_p.pop())

    return s


if __name__ == '__main__':
    minRemoveToMakeValid("(a(b(c)d)")

