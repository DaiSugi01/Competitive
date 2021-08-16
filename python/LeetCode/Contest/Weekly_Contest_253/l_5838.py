from typing import List

class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        start = 0
        for word in words:
            if start >= len(s): break
            if s[start:start+len(word)] != word:
                return False
            start += len(word)

        return start == len(s)


if __name__ == '__main__':
    sol = Solution()
    # s = "z"
    # words = ["z"]
    # s = "ccccccccc"
    # words = ["c", "cc"]
    # s = "iloveleetcode"
    # words = ["i", "love", "leetcode", "apples"]
    # s = "a"
    # words = ["aa", "aaaa", "banana"]
    s = "iloveleetcode"
    words = ["apples", "i", "love", "leetcode"]
    print(sol.isPrefixString(s, words))
