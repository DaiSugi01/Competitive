# https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution:
    def reverseWords(self, s: str) -> str:
        new_s = s.split(' ')

        for (index, word) in enumerate(new_s):
            new_s[index] = word[::-1]

        return ' '.join(new_s)


if __name__ == '__main__':
    sol = Solution()
    s = "Let's take LeetCode contest"
    sol.reverseWords(s)
