package LeetCode.Math;

public class ExcelSheetColumnNumber_171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }

    /*
        A -> 1
        AA -> 27
        AB -> 28

        loop through a split array ['A', 'B']
        res += i * ('A' - 'A' + 1)
        11010
     */
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26;
            res += columnTitle.charAt(i) - 'A' + 1;
        }

        return res;
    }
}
