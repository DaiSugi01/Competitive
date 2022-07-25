package LeetCode.String;

public class RemoveVowelsfromString_1119 {
    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders") == "ltcdscmmntyfrcdrs");
    }

    public static String removeVowels(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
