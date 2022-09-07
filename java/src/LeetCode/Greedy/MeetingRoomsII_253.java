package LeetCode.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {
    /*
        Input: intervals = [[0,30],[5,10],[15,20]]
        Output: 2
     */
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}
