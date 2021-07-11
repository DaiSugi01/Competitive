from typing import List, Iterator, Tuple


def find_symmetric_pair(pairs: List[Tuple[int, int]]) -> Iterator[Tuple[int, int]]:
    cache = {}
    for pair in pairs:
        f, s = pair[0], pair[1]
        val = cache.get(s)
        if not val:
            cache[f] = s
        elif val == f:
            yield pair


if __name__ == '__main__':
    pairs: List[Tuple[int, int]] = [(1, 2), (3, 5), (4, 7), (5, 3), (7, 4)]
    for r in find_symmetric_pair(pairs):
        print(r)
