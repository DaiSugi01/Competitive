import functools
import operator

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows <= 1:
            return s

        arr = [[] for _ in range(numRows)]

        pos = 0
        op = operator.pos
        for c in s:
            arr[pos].append(c)
            if pos <= 0:
                op = operator.pos
            elif pos >= numRows - 1:
                op = operator.neg

            pos += op(1)

        return ''.join(functools.reduce(lambda a, b: a + b, arr))


if __name__ == '__main__':
    solution = Solution()
    s = "PAYPALISHIRING"
    numRows = 3
    solution.convert(s)
