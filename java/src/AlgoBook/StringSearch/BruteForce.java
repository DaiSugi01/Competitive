package AlgoBook.StringSearch;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(practice8_1("ABABCDEFGHA", "ABC"));
        System.out.println(bfMatchLast("ABABCDEFGHA", "ABC"));
    }

    private static int bfMatch(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        while (pt < text.length() && pp < pattern.length()) {
            if (text.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pattern.length()) {
            return pt - pp;
        }

        return -1;
    }

    private static int practice8_1(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        int compCount = 0;
        while (pt < text.length() && pp < pattern.length()) {
            compCount++;
            if (text.charAt(pt) == pattern.charAt(pp)) {
                printProgress(text, pattern, "+", pt, pp);
                pt++;
                pp++;
            } else {
                printProgress(text, pattern, "|", pt, pp);
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        System.out.printf("比較回数は %d回\n", compCount);
        return pp == pattern.length() ? pt - pp : -1;
    }

    private static void printProgress(String text, String pattern, String symbol, int pt, int pp) {
        System.out.println(text);
        System.out.println(" ".repeat(pt) + symbol);
        System.out.println(" ".repeat(pt - pp) + pattern);
        System.out.println("---------------------");
    }

    public static int bfMatchLast(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        int lastIndex = -1;
        while (pt < text.length() && pp < pattern.length()) {
            if (text.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }

            if (pp == pattern.length()) {
                lastIndex = pt - pp;
                pp = 0;
                pt = pt - pp + 1;
            }
        }

        return lastIndex;
    }
}
