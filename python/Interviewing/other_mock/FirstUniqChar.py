def first_uniq_char(s: str) -> int:
    dup: set = set()
    res: [str] = []
    for i in range(len(s)):
        if s[i] in dup:
            if s[i] in res:
                res.remove(s[i])
        else:
            dup.add(s[i])
            res.append(s[i])

    return -1 if len(res) == 0 else s.index(res[0])
