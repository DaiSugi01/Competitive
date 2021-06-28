# https://leetcode.com/problems/longest-palindromic-substring/
def longestPalindrome(s: str) -> str:
    if s is None or len(s) <= 1:
        return s

    start: int = 0
    end: int = 0

    for i in range(len(s)):
        len1: int = expand_around_center(s, i, i)
        len2: int = expand_around_center(s, i, i + 1)
        length: int = max(len1, len2)
        if length > end - start:
            start = i - int((length - 1) / 2)
            end = i + int(length / 2)

    return s[start:end + 1]


def expand_around_center(s: str, left: int, right: int) -> int:
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1

    return right - left - 1


if __name__ == '__main__':
    print(longestPalindrome('baabdb'))
