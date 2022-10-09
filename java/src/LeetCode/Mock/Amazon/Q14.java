package LeetCode.Mock.Amazon;

import java.util.*;

public class Q14 {
    final int[] dy = new int[]{0, 1, 0, -1};
    final int[] dx = new int[]{1, 0, -1, 0};

    int minStep = Integer.MAX_VALUE;

    /*
        [2,3,4]
        [0,10,5]
        [8,7,1]

        [9,2,4]
        [0,8,3]
        [1,6,21]
     */
    public static void main(String[] args) {
        Q14 sol = new Q14();
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1, 2, 3));
        l.add(Arrays.asList(0, 0, 4));
        l.add(Arrays.asList(7, 6, 5));
        System.out.println(sol.cutOffTree(l));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        Queue<Tree> cutOrder = new PriorityQueue<>((i1, i2) -> i1.height - i2.height);
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1)
                    cutOrder.add(new Tree(i, j, forest.get(i).get(j)));
            }
        }

        while (!cutOrder.isEmpty()) {
            Queue<Tree> pq = new PriorityQueue<>((i1, i2) -> i1.height - i2.height);
            pq.add(cutOrder.poll());

            while (!pq.isEmpty()) {
                Tree tree = pq.poll();

                for (int i = 0; i < dx.length; i++) {
                    int ny = tree.y + dy[i];
                    int nx = tree.x + dx[i];

                    if (ny >= 0 && ny < forest.size() && nx >= 0 && nx < forest.get(0).size() && forest.get(ny).get(nx) > 0) {
//                        if (forest.get(ny).get(nx) == pq.p)
                    }
                }
            }
        }


        return minStep;
    }


    class Tree {
        int x;
        int y;
        int height;

        public Tree(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }


}

