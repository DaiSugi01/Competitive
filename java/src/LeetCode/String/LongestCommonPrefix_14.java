package LeetCode.String;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"c", "acc", "ccc"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        /*
            prefix = flower
            
            - flower vs flow
            check if flow contains flower?
                -> NOT, prefix = flowe
            check if flow contains flowe?
                -> NOT, prefix = flow
            check if flow contains flow?
                -> YES, go to next string
            ...
            if prefix is empty
                -> return false
            
            - flow vs flight
            check if flight contains flow?
                -> NOT, prefix = flo
            check if flight contains flo?
                -> NOT, prefix = fl
            check if flight contains fl?
                -> YES, go to next string
            
            return prefix
            
            init prefix variable with the first string[0] -> "flower"
            loop through the string array from index of 1
                check condition if str[i] contains prefix {
                    
                }
                prefix = prefix.substring(0, prefix.length() - 1)
                
         */

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        StringBuffer commonPrefix = new StringBuffer(strs[0]);
        for (String s : strs) {
            while (commonPrefix.length() > 0 && s.indexOf(commonPrefix.toString()) != 0) {
                commonPrefix.delete(commonPrefix.length() - 1, commonPrefix.length());
            }
        }
        return commonPrefix.toString();
    }
}
