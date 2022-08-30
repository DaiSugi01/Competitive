package AlgoBook.StringSearch;

public class KMP {

    public static int kmpMatch(String text, String pattern) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pattern.length() + 1];

        while (pt != pattern.length()) {
            if (pattern.charAt(pt) == pattern.charAt(pp)) {
                System.out.println(pattern);
                System.out.println(" ".repeat(pt) + "T");
                System.out.println(" ".repeat(pp) + "P");
                skip[++pt] = ++pp;
            } else if (pp == 0) {
                System.out.println(pattern);
                System.out.println(" ".repeat(pt) + "T");
                System.out.println(" ".repeat(pp) + "P");
                skip[++pt] = pp;
            } else {
                System.out.println(pattern);
                System.out.println(" ".repeat(pt) + "T");
                System.out.println(" ".repeat(pp) + "P");
                pp = skip[pp];
            }
        }

        pt = pp = 0;
        while (pt != text.length() && pp != pattern.length()) {
            if (text.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }

        }
        if (pp == pattern.length())
            return pt - pp;
        return -1;
    }
}