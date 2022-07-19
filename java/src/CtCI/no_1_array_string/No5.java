package CtCI.no_1_array_string;

public class No5 {
    public static void main(String[] args) {
        System.out.println("apple vs aple: " + oneEditWay("apple", "aple"));
        System.out.println("bale vs pale: " + oneEditWay("bale", "pale"));
        System.out.println("bare vs pale: " + oneEditWay("bare", "pale"));
    }

    public static boolean oneEditWay(String s1, String s2) {
        if (Math.abs(s1.length()) - Math.abs(s2.length()) > 1) return false;

        String shorterStr = s1.length() < s2.length() ? s1 : s2;
        String longerStr = s1.length() < s2.length() ? s2 : s1;

        boolean foundDiff = false;
        int i = 0;
        int j = 0;
        while (i < shorterStr.length() && j < longerStr.length()) {
            if (shorterStr.charAt(i) != longerStr.charAt(j)) {
                if (foundDiff) return false;
                foundDiff = true;
                if (shorterStr.length() == longerStr.length()) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }

        return true;

//        if (s1.length() == s2.length()) {
//            return oneEditReplace(s1, s2);
//        } else if (s1.length() + 1 == s2.length()) {
//            return oneEditInsert(s1, s2);
//        } else if (s1.length() - 1 == s2.length()) {
//            return oneEditInsert(s2, s1);
//        }
//        return false;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDiff) return false;
                foundDiff = true;
            }
        }

        return true;
    }

    public static boolean oneEditInsert(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (i != j) {
                    return false;
                }
            } else {
                i++;
            }
            j++;
        }

        return true;
    }
}
