package LeetCode.Design;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestNumberInInfiniteSet_2336 {
    /*
    "addBack"[2] -> nothing to do
    "popSmallest" -> 1          [2,3,4,5,6,7,8...]
    "popSmallest" -> 2          [3,4,5,6,7,8...]
    "popSmallest" -> 3          [4,5,6,7,8...]
    "addBack"[1]  -> add 1      [1,4,5,6,7,8...]
    "popSmallest" -> 1          [4,5,6,7,8...]
    "popSmallest" -> 4          [5,6,7,8...]
    "popSmallest" -> 5          [6,7,8...]
    [,[],[],[],[1],[],[],[]]
     */
    class SmallestInfiniteSet {
        int counter = 1;
        Set<Integer> set;
        PriorityQueue<Integer> pq;

        public SmallestInfiniteSet() {
            set = new HashSet<>();
            pq = new PriorityQueue<>();
        }

        public int popSmallest() {
            if (pq.isEmpty())
                return counter++;
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }

        public void addBack(int num) {
            if (num >= counter)
                return;

            if (!set.contains(num)) {
                pq.add(num);
                set.add(num);
            }
        }
    }
}
