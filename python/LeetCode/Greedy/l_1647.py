# https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
from collections import Counter


class Solution:
    def minDeletions(self, s: str) -> int:
        counter, used, res = Counter(list(s)), set(), 0

        for k, freq in counter.items():
            while freq > 0 and freq in used:
                freq -= 1
                res += 1
            used.add(freq)

        return res


if __name__ == '__main__':
    sol = Solution()
    print(sol.minDeletions('aab'))
