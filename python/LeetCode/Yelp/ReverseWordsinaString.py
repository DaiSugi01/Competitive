# https://leetcode.com/problems/reverse-words-in-a-string/
def reverseWords(s: str) -> str:
    words = list(filter(lambda x: x != '', s.split(' ')))

    i = 0
    j = len(words) - 1
    while i < j:
        words[i], words[j] = words[j], words[i]
        i += 1
        j -= 1

    return ' '.join(words)
