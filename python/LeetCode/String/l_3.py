# https://leetcode.com/problems/longest-substring-without-repeating-characters/
def length_of_longest_substring(s: str) -> int:
    mx = 0
    set_char: set = set()

    i = 0
    j = 0
    while j < len(s):
        if s[j] not in set_char:
            set_char.add(s[j])
            mx = max(mx, len(set_char))
            j += 1
        else:
            set_char.remove(s[i])
            i += 1

    return mx
