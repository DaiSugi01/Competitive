package LeetCode.Design;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem_1166 {
    class FileSystem {

        Map<String, Integer> cache;

        public FileSystem() {
            cache = new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            Map<String, Integer> a = cache;
            if (path.isEmpty() || path.equals("/") || cache.containsKey(path)) return false;

            int newPathIndex = path.lastIndexOf("/");
            String parent = path.substring(0, newPathIndex);

            if (parent.length() > 1 && !cache.containsKey(parent))
                return false;

            cache.put(path, value);

            return true;
        }

        public int get(String path) {
            if (cache.containsKey(path))
                return cache.get(path);
            else
                return -1;
        }
    }
}
