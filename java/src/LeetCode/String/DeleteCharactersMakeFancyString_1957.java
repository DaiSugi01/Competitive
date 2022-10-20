package LeetCode.String;

public class DeleteCharactersMakeFancyString_1957 {
    public String makeFancyString(String s) {
        StringBuilder fancyString = new StringBuilder();
        fancyString.append(s.charAt(0));
        int i = 0, j = 1, cnt = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                cnt++;
            } else {
                cnt = 1;
                i = j;
            }
            if (cnt <= 2)
                fancyString.append(s.charAt(i));
            j++;
        }

        return fancyString.toString();
    }
}
