package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class SortingTheSentence_1859 {
    public String sortSentence(String s) {
        Map<Integer, String> map = new HashMap<>();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            int index = words[i].charAt(words[i].length() - 1) - '0';
            map.put(index - 1, words[i].substring(0, words[i].length() - 1));
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            words[entry.getKey()] = entry.getValue();
        }

        s = String.join(" ", words);

        return s;
    }
}
