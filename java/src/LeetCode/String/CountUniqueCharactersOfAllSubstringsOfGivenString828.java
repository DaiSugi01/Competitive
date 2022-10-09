package LeetCode.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountUniqueCharactersOfAllSubstringsOfGivenString828 {

    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        CountUniqueCharactersOfAllSubstringsOfGivenString828 sol = new CountUniqueCharactersOfAllSubstringsOfGivenString828();
        System.out.println(sol.uniqueLetterString("ABA"));
    }

    public int uniqueLetterString(String s) {
        helper(s, new HashSet<>());
        int ans = 0;
        for (Object str : set.toArray()) {
            String temp = (String) str;
            ans += temp.length();
        }
        return ans;
    }

    private void helper(String s, Set<String> soFar) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = extractSubstring(s.substring(i, j + 1));
                if (!subString.isEmpty())
                    list.add(subString);
            }
        }
        System.out.println(soFar);
    }

    private String extractSubstring(String subString) {
        Set<Character> uniqueString = new HashSet<>();
        int k;
        for (k = 0; k < subString.length(); k++) {
            if (uniqueString.contains(subString.charAt(k)))
                break;
            uniqueString.add(subString.charAt(k));
        }
        System.out.println(subString);
        return subString.substring(0, k);
    }
}
