//https://leetcode.com/problems/removing-stars-from-a-string/description/
package LeetCode.String;

public class RemovingStarsFromString_2390 {
    public String removeStars(String s) {
        StringBuilder cleanString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*')
                cleanString.setLength(cleanString.length() - 1);
            else
                cleanString.append(c);
        }

        return cleanString.toString();
    }
}
