package CtCI.no_1_array_string;

public class No4 {

    private static final int a = Character.getNumericValue('a');
    private static final int z = Character.getNumericValue('z');

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("tact coa"));
    }

    public static boolean isPermutationOfPalindrome(String s) {
//        int[] table = buildCharFreqTable(s);
//        return checkTable(table);
        return buildCharFreqTable(s);
    }

//    private static boolean checkTable(int[] table) {
//        boolean isFoundOdd = false;
//        for (int i : table) {
//            if (i % 2 == 1) {
//                if (isFoundOdd) return false;
//                isFoundOdd = true;
//            }
//        }
//
//        return true;
//    }

    private static boolean buildCharFreqTable(String s) {
        int[] table = new int[z - a + 1];
        int countOdd = 0;
        for (char c : s.toCharArray()) {
            int x = getCharNum(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                }
            }
        }

        return countOdd <= 1;
    }

    private static int getCharNum(char c) {
        int val = Character.getDirectionality(c);
        if (a <= val && z <= val) {
            return val - a;
        }

        return -1;
    }
}
