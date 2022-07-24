from collections import Counter


def isAnagram(s: str, t: str) -> bool:
    if len(s) != len(t): return False

    dic_s = Counter(s)
    dic_t = Counter(t)

    return dic_s == dic_t

    # s1 = Counter(s)
    #
    # for char in t:
    #     if char not in s1: return False
    #
    #     s1[char] -= 1
    #     if s1[char] < 0:
    #         return False
    #
    # return True
