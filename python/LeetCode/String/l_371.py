# https://leetcode.com/problems/sum-of-two-integers/
class Solution:
    def getSum(self, a: int, b: int) -> int:
        x, y = abs(a), abs(b)

        if x < y:
            return self.getSum(b, a)

        sign: int = 1 if a > 0 else -1

        if a * b >= 0:
            while y:
                x, y = x ^ y, (x & y) << 1
        else:
            while y:
                x, y = x ^ y, ((~x) & y) << 1

        return x * sign

if __name__ == '__main__':
    s: Solution = Solution()
    print(s.getSum(15, 2))
