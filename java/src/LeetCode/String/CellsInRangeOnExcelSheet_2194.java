//https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/submissions/930653296/
package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class CellsInRangeOnExcelSheet_2194 {
    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0), c2 = s.charAt(3);
        char r1 = s.charAt(1), r2 = s.charAt(4);

        List<String> cells = new ArrayList<>();
        for (char c = c1; c <= c2; c++) {
            for (char r = r1; r <= r2; r++) {
                cells.add("" + c + r);
            }
        }

        return cells;
    }
}