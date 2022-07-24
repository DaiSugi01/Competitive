from typing import List


def longestCommonPrefix(strs: List[str]) -> str:
    if len(strs) <= 0: return ""

    common_pre = list(strs[0])
    for i in range(1, len(strs)):
        j = 0
        last = len(strs[i]) if len(common_pre) > len(strs[i]) else len(common_pre)
        while j < last and common_pre[j] == strs[i][j]:
            j += 1

        common_pre = common_pre[:j]

    return ''.join(common_pre)
