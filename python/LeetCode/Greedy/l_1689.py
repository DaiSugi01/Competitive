# https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
class Solution:
    def minPartitions(self, n: str) -> int:
        return max(list(n))


if __name__ == '__main__':
    n = "27346209830709182346"
    sol = Solution()
    sol.minPartitions(n)
