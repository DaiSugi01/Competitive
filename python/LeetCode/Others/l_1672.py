# https://leetcode.com/problems/richest-customer-wealth/
from typing import List


def maximumWealth(accounts: List[List[int]]) -> int:
    max_val: int = 0
    for account in accounts:
        max_val = max(max_val, sum(account))

    return max_val


if __name__ == '__main__':
    print(maximumWealth([[1,2,3],[3,2,1]]))
