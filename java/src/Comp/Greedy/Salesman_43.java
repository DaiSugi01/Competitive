package Comp.Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Salesman_43 {
    public static void main(String[] args) {
        int[] starts = new int[]{1, 2, 4, 6, 8};
        int[] ends = new int[]{3, 5, 7, 9, 10};
        System.out.println(salesman(starts.length, starts, ends));
    }

    private static ArrayList<Meeting> salesman(int numOfWork, int[] starts, int[] ends) {
        PriorityQueue<Meeting> pq = new PriorityQueue<>((p1, p2) -> p1.end - p2.end);
        for (int i = 0; i < starts.length; i++) {
            pq.add(new Meeting(starts[i], ends[i]));
        }

        ArrayList<Meeting> ans = new ArrayList<>();
        int currentEnd = 0;
        for (int i = 0; i < numOfWork; i++) {
            Meeting p = pq.poll();
            if (p.start >= currentEnd) {
                ans.add(p);
                currentEnd = p.end;
            }
        }

        return ans;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meeting(start=" + String.valueOf(start) + ", end=" + String.valueOf(end) + ")";
        }
    }
}
