# biz1 -> "AA BBB CCC"
# biz2 -> "AAA BBB CCC DDD"
# 2/5

biz1 = "A B"
biz2 = ""
def calc_common_score(biz1: str, biz2: str):
    if len(biz1) <= 0 or len(biz2) <= 0: return 0.0
    if biz1 is None or biz2 is None: return 0.0

    s1 = set(biz1.split(' '))
    s2 = set(biz2.split(' '))

    return len(s1 & s2) / len(s1 | s2)


def most_closest_biz(origin_biz, businesses):
    max_score = 0
    res = {}
    for biz in range(businesses):
        biz_score = calc_common_score(origin_biz["name"], biz["name"])
        if biz_score > max_score:
            max_score = biz_score
            res = biz

    return res


if __name__ == '__main__':
    biz1 = "A B"
    biz2 = "C A B"
    print(calc_common_score(biz1, biz2))
