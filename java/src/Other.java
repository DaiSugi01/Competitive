import java.util.*;

public class Other {
    public static void main(String[] args) {
//        String[] arr = new String[]{
//                "101",
//                "010",
//        };
//        System.out.println(func2(arr));
//        System.out.println(func3());
        System.out.println(func4(Arrays.asList(14, 20, 4, 12, 5, 11)) == 8);
        System.out.println(func4(Arrays.asList(1, 2, 3, 4, 5)) == 4);
        System.out.println(func4(Arrays.asList(1, 10)) == 9);
        System.out.println(func4(Arrays.asList(10, 12, 4, 5, 9)) == 5);
        System.out.println(func4(Arrays.asList(10, 12, 4, 5, 9)) == 5);
    }

    public static int func4(List<Integer> list) {
        int highestPrice = list.get(0);
        int lowestPrice = list.get(0);
        int profit = -1;
        for (int i = 1; i < list.size(); i++) {
            if (lowestPrice > list.get(i)) {
                lowestPrice = list.get(i);
                highestPrice = list.get(i);
            } else {
                highestPrice = Math.max(highestPrice, list.get(i));
            }
            profit = Math.max(profit, highestPrice - lowestPrice);
        }

        return profit;
    }

    public static int func3() {
        // output -> 5
//        List<Integer> list = new ArrayList<>(Arrays.asList(10, 12, 4, 5, 9));
        // output -> 8
        /*
            low = 14
            high = 20

             profit = 8
         */
//        List<Integer> list = new ArrayList<>(Arrays.asList(14, 20, 4, 12, 5, 11));
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        List<Integer> list = new ArrayList<>(Arrays.asList(5, 10, 4, 6, 7));
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 10));
        int highestPrice = list.get(list.size() - 1);
        int lowestPrice = list.get(list.size() - 1);
        int ans = -1;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (highestPrice < list.get(i)) {
                highestPrice = list.get(i);
                lowestPrice = Integer.MAX_VALUE;
            } else {
                highestPrice = Math.max(highestPrice, list.get(i));
                lowestPrice = Math.min(lowestPrice, list.get(i));
            }
            ans = Math.max(ans, highestPrice - lowestPrice);
        }
        return ans;
    }

    public static int func1(int[] arr) {
        boolean isIncrease = false;
        if (arr[0] < arr[1]) {
            isIncrease = true;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (isIncrease) {
                if (arr[i] > arr[i + 1]) {
                    return i;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static int func2(String[] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length()];
        int ans = 0;
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length(); x++) {
                if (arr[y].charAt(x) == '0' && !visited[y][x]) {
                    visited[y][x] = true;
                    bfs(x, y, visited, arr);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void bfs(int x, int y, boolean[][] visited, String[] arr) {
        final int[] dy = {0, 1, 0, -1};
        final int[] dx = {1, 0, -1, 0};
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair p = queue.pop();
            visited[p.y][p.x] = true;

            for (int i = 0; i < dy.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= arr[0].length() || ny < 0 || ny >= arr.length)
                    continue;

                if (visited[ny][nx]) {
                    continue;
                }

                if (arr[ny].charAt(nx) == '0') {
                    visited[ny][nx] = true;
                    queue.add(new Pair(nx, ny));
                }

            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
