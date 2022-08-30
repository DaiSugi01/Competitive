package AlgoBook.StringSearch;

public class BoyerMoore {
    public static int bmMatch(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        int textLen = text.length();
        int ptLen = pattern.length();
        int[] skip = new int[26];

        for (pt = 0; pt < skip.length; pt++)
            skip[pt] = ptLen;
        for (pt = 0; pt < ptLen - 1; pt++)
            skip[pattern.charAt(pt) - 'A'] = ptLen - pt - 1;

        while (pt < textLen) {
            pp = ptLen - 1;
            printProgress(text, pattern, pt, ptLen);
            while (text.charAt(pt) == pattern.charAt(pp)) {
                if (pp == 0)
                    return pt;
                pp--;
                pt--;
                printProgress(text, pattern, pt, ptLen);
            }
            pt += Math.max(skip[text.charAt(pt) - 'A'], ptLen - pp);
        }
        return -1;
    }

    private static void printProgress(String text, String pattern, int pt, int ptLen) {
        System.out.println(text);
        System.out.println(pt == ptLen ? " ".repeat(pt - 1) + "|" : " ".repeat(pt) + "|");
        System.out.println(pt == ptLen - 1 ? "" + pattern : " ".repeat(pt - ptLen + 1) + pattern);
        System.out.println("------------------------");
    }
}
