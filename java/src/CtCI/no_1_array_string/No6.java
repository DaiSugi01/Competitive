package CtCI.no_1_array_string;

public class No6 {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("abc"));
    }

    /*
        input: aabcccccaaa
        output: a2b1c4a3
     */
    public static String compress(String str) {
        StringBuffer compressed = new StringBuffer();
        int dupCount = 0;
        for (int i = 0; i < str.length(); i++) {
            dupCount++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(dupCount);
                dupCount = 0;
            }
        }

        return compressed.toString().length() < str.length() ? compressed.toString() : str;
    }
}
