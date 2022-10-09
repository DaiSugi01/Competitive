package LeetCode.Design;

public class DesignCompressedStringIterator_604 {
    class StringIterator {
        String res;
        char c;
        int ptr = 0;
        int num = 0;

        public StringIterator(String compressedString) {
            res = compressedString;
        }

        public char next() {
            if (!hasNext())
                return ' ';

            if (num == 0) {
                c = res.charAt(ptr++);
                while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                    num = num * 10 + res.charAt(ptr++) - '0';
                }
            }
            num--;
            return c;
        }

        public boolean hasNext() {
            return ptr != res.length() || num != 0;
        }
    }
}
