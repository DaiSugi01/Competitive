# https://leetcode.com/problems/verifying-an-alien-dictionary/
from typing import Dict, List


def isAlienSorted(words: List[str], order: str) -> bool:
    alp_order: Dict = {}
    for i in range(len(order)):
        alp_order[order[i]] = i

    for i in range(len(words) - 1):
        for j in range(len(words[i])):
            if j >= len(words[i + 1]):
                return False

            if words[i][j] != words[i + 1][j]:
                if alp_order[words[i][j]] > alp_order[words[i + 1][j]]:
                    return False
                break

    return True


if __name__ == '__main__':
    words = ["apple", "app"]
    order = "abcdefghijklmnopqrstuvwxyz"
    # words = ["word", "world", "row"]
    # order = "worldabcefghijkmnpqstuvxyz"
    print(isAlienSorted(words, order))
