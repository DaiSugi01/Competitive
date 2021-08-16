# https://leetcode.com/problems/car-pooling/
class Solution(object):
    def carPooling(self, trips, capacity):
        """
        :type trips: List[List[int]]
        :type capacity: int
        :rtype: bool
        """
        timestamp = []
        for trip in trips:
            timestamp.append([trip[1], trip[0]])
            timestamp.append([trip[2], -trip[0]])

        timestamp.sort()

        used_capacity = 0
        for time, passenger_change in timestamp:
            used_capacity += passenger_change
            if used_capacity > capacity:
                return False

        return True


if __name__ == '__main__':
    trips = [[3,5,9],[4,2,5],[3,4,6],[9,1,4],[5,6,8],[5,4,6]]
    capacity = 14
    sol = Solution()
    print(sol.carPooling(trips, capacity))
