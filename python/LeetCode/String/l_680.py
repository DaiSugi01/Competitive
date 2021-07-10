# https://leetcode.com/problems/valid-palindrome-ii/
def validPalindrome(s: str) -> bool:
    left, right = 0, len(s) - 1
    while left < right:
        if s[left] != s[right]:
            print(left, right)
            print(s)
            one, two = s[left:right], s[left + 1:right + 1]
            print(one)
            print(one[::-1])
            print(two)
            print(two[::-1])
            return one == one[::-1] or two == two[::-1]
        left, right = left + 1, right - 1

    return True


if __name__ == '__main__':
    validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga")
