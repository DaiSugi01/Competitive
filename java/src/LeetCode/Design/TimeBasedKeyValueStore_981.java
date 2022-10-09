package LeetCode.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {
    /*
        {
            foo: {1, bar},{4, bar2}
        }
     */
    class TimeMap {
        Map<String, TreeMap<Integer, String>> keyMap;

        public TimeMap() {
            keyMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!keyMap.containsKey(key))
                keyMap.put(key, new TreeMap<>());
            keyMap.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!keyMap.containsKey(key))
                return "";
            Integer floorKey = keyMap.get(key).floorKey(timestamp);
            if (floorKey == null)
                return "";

            return keyMap.get(key).get(floorKey);
        }
    }

    class TimeVal {
        int timestamp;
        String val;

        public TimeVal(int t, String v) {
            timestamp = t;
            val = v;
        }
    }
}
