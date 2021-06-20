# https://leetcode.com/problems/rearrange-spaces-between-words/
def reorder_spaces(text: str) -> str:
    def is_not_blank(w):
        return w != ""

    space: int = 0
    for i in range(len(text)):
        space += 1 if text[i] == ' ' else 0

    words: [str] = list(filter(is_not_blank, text.split(' ')))

    if len(words) == 1:
        return ''.join(words) + ' ' * space

    e_space: int = int(space / (len(words) - 1))

    res: str = (' ' * e_space).join(words)

    return res + ' ' * (space - e_space)
