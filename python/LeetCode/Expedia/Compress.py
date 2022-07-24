# https://leetcode.com/problems/string-compression/
from typing import List


class Solution:
    def compress(self, chars: List[str]) -> int:
        # use 2 pointers
        # loop through the chars list (keep current char and initialize counter by 0
        # loop through until the next char is not the same
        # if the counter is greater than 1, add char & the counter, otherwise, just add char
        # update the array

        chars_index = 0
        i = 0
        while i < len(chars):
            current_char = chars[i]
            counter = 0
            while i < len(chars) and chars[i] == current_char:
                counter += 1
                i += 1

            chars[chars_index] = current_char
            chars_index += 1

            if counter > 1:
                for c in str(counter):
                    chars[chars_index] = c
                    chars_index += 1

        chars = chars[:chars_index]
        return len(chars)
