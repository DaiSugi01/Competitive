# https://leetcode.com/problems/add-strings/
from typing import List


def addStrings(num1: str, num2: str) -> str:
    res: List[str]= []
    carry: int = 0

    p1: int = len(num1) - 1
    p2: int = len(num2) - 1
    while p1 >= 0 or p2 >= 0:
        x1 = ord(num1[p1]) - ord('0') if p1 >= 0 else 0
        x2 = ord(num2[p2]) - ord('0') if p2 >= 0 else 0
        value = (x1 + x2 + carry) % 10
        carry = (x1 + x2 + carry) // 10
        res.append(value)
        p1 -= 1
        p2 -= 1

    if carry:
        res.append(carry)

    return ''.join(str(x) for x in res[::-1])


if __name__ == '__main__':
    num1 = "19"
    num2 = "129"
    print(addStrings(num1, num2))
