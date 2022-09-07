package LeetCode.Math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {
    public static void main(String[] args) {
        RomanToInteger_13 sol = new RomanToInteger_13();
        System.out.println(sol.romanToInt("MCMXCIV"));
    }

    /*
        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    public int romanToInt(String s) {
        Map<Character, Integer> values = makeMap();
        int sum = values.get(s.charAt(s.length() - 1));
        char prev = s.charAt(s.length() - 1);
        for (int i = s.length() - 2; i >= 0; i--) {
            int currentNum = values.get(s.charAt(i));
            if (currentNum < values.get(prev))
                sum -= currentNum;
            else
                sum += currentNum;
            prev = s.charAt(i);
        }

        return sum;
    }

    private Map<Character, Integer> makeMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        return map;
    }
//    public static int romanToInt(String s) {
//        int sum = 0;
//        char prev = ' ';
//        for (int i = 0; i < s.length(); i++) {
//            sum += getVal(s.charAt(i), prev);
//            prev = s.charAt(i);
//        }
//
//        return sum;
//    }
//
//    private static int getVal(char c, char prev) {
//        switch (c) {
//            case 'I':
//                return 1;
//            case 'V':
//                // IX == 4, if prev == I,
//                return prev == 'I' ? 3 : 5;
//            case 'X':
//                return prev == 'I' ? 8 : 10;
//            case 'L':
//                return prev == 'X' ? 30 : 50;
//            case 'C':
//                return prev == 'X' ? 80 : 100;
//            case 'D':
//                return prev == 'C' ? 300 : 500;
//            case 'M':
//                return prev == 'C' ? 800 : 1000;
//        }
//
//        throw new IllegalArgumentException();
//    }
}
