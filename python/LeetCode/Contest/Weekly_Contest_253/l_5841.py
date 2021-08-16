from bisect import bisect_right
from typing import List


class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        lks=[]
        for i in range(len(obstacles)):
            x=obstacles[i]
            if len(lks)==0 or lks[-1]<=x:
                lks.append(x)
                obstacles[i]=len(lks)
            else:
                k=bisect_right(lks,x)
                lks[k]=x
                obstacles[i]=k+1
            print(lks)
        return obstacles

        # if len(obstacles) <= 1: return len(obstacles)
        #
        # dp = [1]
        # if obstacles[1] >= obstacles[0]:
        #     dp.append(2)
        # else:
        #     dp.append(1)
        #
        # # memo = collections.defaultdict(int)
        # memo = [0 for _ in range(max(obstacles)+1)]
        # memo[obstacles[0]] = dp[0]
        # memo[obstacles[1]] = dp[1]
        #
        # for i in range(2, len(obstacles)):
        #     key = obstacles[i]
        #     memo[key] = max(memo[1:key+1]) + 1
        #     dp.append(memo[key])

        # for i in range(2, len(obstacles)):
        #     maximum = 0
        #     key = obstacles[i]
        #     print(key)
        #     print(max(memo[1:key+1]), memo[1:key+1])
        #     for k in range(1, obstacles[i]+1):
        #         if k in memo:
        #             if memo[k] > maximum:
        #                 maximum = memo[k]
        #                 key = k
        #
        #     memo[obstacles[i]] = memo[key] + 1
        #     dp.append(memo[obstacles[i]])

        return dp


if __name__ == '__main__':
    sol = Solution()
    obstacles = [5,2,5,4,1,1,1,5,3,1]
    print('Expect:', [1,1,2,2,1,2,3,4,4,4])

    # obstacles = [5, 1, 5, 5, 1, 3, 4, 5, 1, 4]
    # print('Expect:', [1, 1, 2, 3, 2, 3, 4, 5, 3, 5])

    # obstacles = [1, 2, 3, 2]
    # obstacles = [2, 2, 1]

    # obstacles = [1, 2, 3, 2]
    print('Ans:   ', sol.longestObstacleCourseAtEachPosition(obstacles))
