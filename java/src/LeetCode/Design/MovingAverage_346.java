package LeetCode.Design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage_346 {

    public static void main(String[] args) {
        MovingAverage_346 ave = new MovingAverage_346(3);
        System.out.println(ave.next(1));
        System.out.println(ave.next(10));
        System.out.println(ave.next(3));
        System.out.println(ave.next(5));
    }

    private int size;
    private Deque<Integer> queue;
    private int windowSum;
    private int count;

    public MovingAverage_346(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>();
        this.windowSum = 0;
        this.count = 0;
    }

    /*
        using queue -> [1, 10, 3, 5]
        windowSum = sum of items
        if queue size > windowSize
            -> windowSum = windowSum - queue.poll() + val
        else
            -> windowSum = windowSum + val
        return windowSum * 1.0 / Math.min(size, count)
     */
    public double next(int val) {
        count++;
        queue.add(val);
        int tail = count > this.size ? queue.poll() : 0;
        this.windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}

