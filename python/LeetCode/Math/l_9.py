# https://leetcode.com/problems/palindrome-number/
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or x % 10 == 0 and x != 0:
            return False

        n = 0
        temp = x
        while temp > 0:
            n = n * 10 + temp % 10
            temp = temp // 10

        return x == n or x == n / 10
