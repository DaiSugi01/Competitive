# https://leetcode.com/problems/meeting-rooms-ii/
import heapq

def minMeetingRooms(intervals):
    """
    :type intervals: List[List[int]]
    :rtype: int
    """
    reserved = []
    intervals.sort(key=lambda x: x[0])

    heapq.heappush(reserved, intervals[0][1])

    for i in intervals[1:]:
        if i[0] >= reserved[0]:
            heapq.heappop(reserved)

        heapq.heappush(reserved, i[1])

    return len(reserved)


if __name__ == '__main__':
    intervals = [[0,30],[5,10],[15,20]]
    print(minMeetingRooms(intervals))
