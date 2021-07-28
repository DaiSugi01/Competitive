# https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        p = {
            '(': ')',
            '{': '}',
            '[': ']'
        }
        for c in s:
            if c in p:
                stack.append(c)
            elif not stack:
                return False
            elif c != p[stack.pop()]:
                return False

        return len(stack) == 0
