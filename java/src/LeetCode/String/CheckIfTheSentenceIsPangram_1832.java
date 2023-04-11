//https://leetcode.com/problems/check-if-the-sentence-is-pangram/submissions/930675058/
package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class CheckIfTheSentenceIsPangram_1832 {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;

        Map<Character, Boolean> map = new HashMap<>();
        for (Character c : sentence.toCharArray()) {
            map.put(c, true);
            if (map.size() == 26) return true;
        }

        return false;
    }
}
