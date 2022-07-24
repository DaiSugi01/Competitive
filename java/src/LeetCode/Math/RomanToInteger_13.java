package LeetCode.Math;

public class RomanToInteger_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            sum += getVal(s.charAt(i), prev);
            prev = s.charAt(i);
        }

        return sum;
    }

    private static int getVal(char c, char prev) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                // IX == 4, if prev == I,
                return prev == 'I' ? 3 : 5;
            case 'X':
                return prev == 'I' ? 8 : 10;
            case 'L':
                return prev == 'X' ? 30 : 50;
            case 'C':
                return prev == 'X' ? 80 : 100;
            case 'D':
                return prev == 'C' ? 300 : 500;
            case 'M':
                return prev == 'C' ? 800 : 1000;
        }

        throw new IllegalArgumentException();
    }
}
