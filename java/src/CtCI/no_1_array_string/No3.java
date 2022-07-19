package CtCI.no_1_array_string;

public class No3 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith ", 13));
    }

    public static String replaceSpaces(String s, int len) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
