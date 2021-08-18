# https://leetcode.com/problems/string-matching-in-an-array/
from collections import UserList


class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        res = set()
        for i in range(len(words)):
            for j in range(len(words)):
                if j == i: continue
                if words[i] in words[j]:
                    res.add(words[i])
        return list(res)


if __name__ == '__main__':
    words = ["leetcode", "et", "code"]
    sol = Solution()
    print(sol.stringMatching(words))
