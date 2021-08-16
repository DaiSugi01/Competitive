class Solution:
    def minSwaps(self, s: str) -> int:
        if not s: return 0

        stack = []
        for b in s:
            if b == '[':
                stack.append(b)
            else:
                if stack:
                    stack.pop()

        res = 0
        i = 0
        while i < len(stack):
            res += 1
            i += 2

        return res


if __name__ == '__main__':
    sol = Solution()
    s = "][][" # --> 1
    print(sol.minSwaps(s))

    s = "]]][[[" # --> 2
    print(sol.minSwaps(s))

    s = "]][[" # --> 1
    print(sol.minSwaps(s))

    s = "[[][]]][" # --> 1
    print(sol.minSwaps(s))

    s = "[][[[]]][]" # --> 0
    print(sol.minSwaps(s))
