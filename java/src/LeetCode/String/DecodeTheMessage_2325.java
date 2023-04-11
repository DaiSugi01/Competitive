//https://leetcode.com/problems/decode-the-message/submissions/930637385/
package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage_2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char currentChar = 'a';
        for (char c : key.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' < 26 && !map.containsKey(c))
                map.put(c, currentChar++);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append(c - 'a' >= 0 && c - 'a' < 26 ? map.get(c) : c);
        }

        return sb.toString();
    }
}
