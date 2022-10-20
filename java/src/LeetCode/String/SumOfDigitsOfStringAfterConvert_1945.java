package LeetCode.String;

public class SumOfDigitsOfStringAfterConvert_1945 {
    public int getLucky(String s, int k) {
        String numString = convert(s);
        String ans = numString;
        for (int i = 0; i < k; i++) {
            ans = transform(ans);
        }

        return Integer.parseInt(ans);
    }

    private String convert(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        return sb.toString();
    }

    private String transform(String numString) {
        int sum = 0;
        for (char num : numString.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(num));
        }

        return String.valueOf(sum);
    }
}
