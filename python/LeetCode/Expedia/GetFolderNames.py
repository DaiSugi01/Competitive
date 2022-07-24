# https://leetcode.com/problems/making-file-names-unique/
from typing import List


class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        dic = {}
        n = len(names)
        res = ["" for _ in range(n)]

        for i in range(n):
            if names[i] not in dic:
                res[i] = names[i]
                dic[names[i]] = 1
                continue

            new_name = f"{names[i]}({dic[names[i]]})"

            while new_name in dic:
                dic[names[i]] += 1
                new_name = f"{names[i]}({dic[names[i]]})"

            res[i] = new_name
            dic[new_name] = 1

        return res