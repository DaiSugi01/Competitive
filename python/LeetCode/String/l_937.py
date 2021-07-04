# https://leetcode.com/problems/reorder-data-in-log-files/
from typing import List


def reorderLogFiles(logs: List[str]) -> List[str]:
    def get_keys(log):
        _id, rest = log.split(' ', maxsplit=1)
        return (0, rest, _id) if rest[0].isalpha() else (1, )

    return sorted(logs, key=get_keys)


if __name__ == '__main__':
    reorderLogFiles(["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"])
