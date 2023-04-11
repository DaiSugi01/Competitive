//https://leetcode.com/problems/count-items-matching-a-rule/description/
package LeetCode.Array;

import java.util.List;

public class CountItemsMatchingRule_1773 {
    final int TYPE_INDEX = 0;
    final int COLOR_INDEX = 1;
    final int NAME_INDEX = 2;

    final String TYPE = "type";
    final String COLOR = "color";
    final String NAME = "name";

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchedItem = 0;
        for (List<String> item : items) {
            if (ruleKey.equals(TYPE)) {
                matchedItem += ruleValue.equals(item.get(TYPE_INDEX)) ? 1 : 0;
            } else if (ruleKey.equals(COLOR)) {
                matchedItem += ruleValue.equals(item.get(COLOR_INDEX)) ? 1 : 0;
            } else if (ruleKey.equals(NAME)) {
                matchedItem += ruleValue.equals(item.get(NAME_INDEX)) ? 1 : 0;
            }
        }

        return matchedItem;
    }
}
