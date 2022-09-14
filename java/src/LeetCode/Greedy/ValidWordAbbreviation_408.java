package LeetCode.Greedy;

public class ValidWordAbbreviation_408 {
    public static void main(String[] args) {
        ValidWordAbbreviation_408 sol = new ValidWordAbbreviation_408();
        System.out.println(sol.validWordAbbreviation("hi", "hi1"));
        System.out.println(sol.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(sol.validWordAbbreviation("internationalization", "i5a11o1"));
        System.out.println(sol.validWordAbbreviation("apple", "a2le"));
        System.out.println(sol.validWordAbbreviation("apple", "a2e"));
        System.out.println(sol.validWordAbbreviation("aaa", "a0aa"));
        System.out.println(sol.validWordAbbreviation("a", "2"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (abbr.charAt(j) == '0' || !Character.isDigit(abbr.charAt(j)))
                return false;

            int num = 0;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + abbr.charAt(j) - '0';
                j++;
            }

            i += num;
        }

        return i == word.length() && j == abbr.length();
    }
}
