package LeetCode.Design;

import java.util.ArrayList;
import java.util.List;

public class DesignOrderedStream_1656 {
    class OrderedStream {
        public int nextKey;
        public String[] list;

        public OrderedStream(int n) {
            nextKey = 1;
            list = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            list[idKey - 1] = value;
            int key = nextKey;

            List<String> result = new ArrayList();

            while (key < list.length && list[key] != null) {
                result.add(list[key++]);
            }
            return result;
        }
    }
}
