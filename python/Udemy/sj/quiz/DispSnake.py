import operator
from typing import List


def snake_string_v1(chars: str) -> List[List[str]]:
    res = [[], [], []]
    res_indexes = {0, 1, 2}
    insert_index = 1
    for i, s in enumerate(chars):
        if i % 4 == 1:
            insert_index = 0
        elif i % 2 == 0:
            insert_index = 1
        elif i % 4 == 3:
            insert_index = 2
        res[insert_index].append(s)
        for rest_index in res_indexes - {insert_index}:
            res[rest_index].append(' ')

    return res


def snake_string_v2(chars: str, depth: int) -> List[List[str]]:
    res = [[] for _ in range(depth)]
    result_indexes = {i for i in range(depth)}
    insert_index = depth // 2

    # def pos(i):
    #     return i + 1
    #
    # def neg(i):
    #     return i - 1

    # op = neg
    op = operator.neg

    for c in chars:
        res[insert_index].append(c)
        for rest in result_indexes - {insert_index}:
            res[rest].append(' ')
        if insert_index <= 0:
            # op = pos
            op = operator.pos
        elif insert_index == depth - 1:
            op = operator.neg
        # insert_index = op(insert_index)
        insert_index += op(1)

    return res


if __name__ == '__main__':
    # nums = [str(i) for j in range(5) for i in range(10)]
    # strings = ''.join(nums)
    # for line in snake_string_v1(strings):
    #     print(''.join(line))

    import string
    alphabet = [s for _ in range(2) for s in string.ascii_lowercase]
    strings = ''.join(alphabet)
    for line in snake_string_v2(strings, 10):
        print(''.join(line))
