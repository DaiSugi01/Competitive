package CtCI.no_1_array_string;

public class No9 {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("waterbottle", "erbotlewat"));
    }

    /*
        s1 + s1 = waterbottlewaterbottle
     */
    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) return false;

        String s1S1 = s1 + s1;
        return isSubstring(s1S1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        String shorterStr = s1.length() < s2.length() ? s1 : s2;
        String longerStr = s1.length() < s2.length() ? s2 : s1;
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (longerStr.charAt(i) == shorterStr.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == s2.length();
    }
}
