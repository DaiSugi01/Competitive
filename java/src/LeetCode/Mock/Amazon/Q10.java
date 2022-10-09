package LeetCode.Mock.Amazon;

public class Q10 {
    public static void main(String[] args) {
        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        int n = 7;
        Q10 sol = new Q10();
        int[] res = sol.prisonAfterNDays(cells, n);
        for (int num : res) {
            System.out.print(String.valueOf(num) + ", ");
        }
    }

    /*
        Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
        Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
        Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
        Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
        Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
        Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
        Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
        Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        boolean[] checked = new boolean[cells.length];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                if ((cells[j - 1] == 1 && !checked[j - 1] || cells[j - 1] == 0 && checked[j + 1]) &&
                        (cells[j + 1] == 1 && !checked[j + 1] || cells[j + 1] == 0 && checked[j + 1]) &&
                        cells[j] == 0) {
                    checked[j] = true;
                    cells[j] = 1;
                } else {
                    checked[j] = true;
                    cells[j] = 0;
                }
            }
        }

        return cells;
    }
}
