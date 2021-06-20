# https://leetcode.com/problems/unique-morse-code-words/
from typing import List


def unique_morse_representations(words: List[str]) -> int:
    morse: [str] = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                    "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]

    res: set = set()

    for word in words:
        con_morse: [str] = []
        for c in word:
            con_morse.append(morse[ord(c) - ord('a')])
        res.add(''.join(con_morse))

    return len(res)
