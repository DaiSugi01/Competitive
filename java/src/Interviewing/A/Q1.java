package Interviewing.A;

import java.util.*;

public class Q1 {
    final int[] chars = new int[26];

    public static void main(String[] args) {
//        List<String> l = new ArrayList<>(Arrays.asList("bagbag", "sfe", "cbh", "cbh", "red"));
        List<String> l = new ArrayList<>(Arrays.asList("corn", "horn", "dpso", "eqtp", "corn"));
        System.out.println(countFamilyLogins(l));
    }

    public static int countFamilyLogins(List<String> logins) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : logins) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;
        for (String s : logins) {
            String rotated = forwardRotate(s);
            if (map.containsKey(rotated)) {
                ans += map.get(rotated);
            }

            rotated = backwardRotate(s);
            if (map.containsKey(rotated)) {
                ans += map.get(rotated);
            }
        }

        return ans / 2;
    }

    private static String backwardRotate(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c - 'a' - 1 >= 0) {
                sb.append((char) ((int) c - 1));
            } else {
                sb.append('z');
            }
        }

        return sb.toString();
    }

    private static String forwardRotate(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c - 'a' + 1 <= 25) {
                sb.append((char) ((int) c + 1));
            } else {
                sb.append('a');
            }
        }

        return sb.toString();
    }
}
