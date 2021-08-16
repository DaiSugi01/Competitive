# https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
class Solution:
    def maxDepth(self, s: str) -> int:
        max_len = 0
        count = 0

        for c in s:
            if c == '(':
                count += 1
            elif c == ')':
                max_len = max(count, max_len)
                count -= 1

        return max_len