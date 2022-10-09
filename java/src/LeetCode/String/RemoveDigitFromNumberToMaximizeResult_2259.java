package LeetCode.String;

public class RemoveDigitFromNumberToMaximizeResult_2259 {
    public static void main(String[] args) {
        RemoveDigitFromNumberToMaximizeResult_2259 sol = new RemoveDigitFromNumberToMaximizeResult_2259();
//        System.out.println(sol.removeDigit("2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471", '3'));
        System.out.println(sol.removeDigit("123", '3'));
        System.out.println(sol.removeDigit("1231", '1'));
        System.out.println(sol.removeDigit("551", '5'));
    }

    public String removeDigit(String number, char digit) {
        char[] chars = number.toCharArray();
        String ans = " ";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == digit) {
                String newNum = number.substring(0, i).concat(number.substring(i + 1, number.length()));
                if (newNum.compareTo(ans) > 0)
                    ans = newNum;
            }
        }

        return ans;
    }
}
