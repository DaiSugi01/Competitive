package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RearrangeWordsSentence_1451 {
    /*
        input : To be or not to be
        output: To be or to be not

        arr = [
            1: [],
            2: [to, be, or, to, be],
            3: [not]
        ]
     */
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        Map<Integer, List<String>> lenCount = new HashMap<>();
        int size = 0;
        for (String w : words) {
            size = Math.max(size, w.length());
            List<String> list;
            if (!lenCount.containsKey(w.length()))
                list = new ArrayList<>();
            else
                list = lenCount.get(w.length());

            list.add(w.toLowerCase());
            lenCount.put(w.length(), list);
        }

        StringBuilder newText = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            if (!lenCount.containsKey(i)) continue;
            for (String s : lenCount.get(i)) {
                if (newText.length() == 0)
                    s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
                newText.append(s + " ");
            }
        }

        return newText.toString().trim();
    }
}
