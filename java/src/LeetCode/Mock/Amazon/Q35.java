package LeetCode.Mock.Amazon;

import java.util.*;
import java.util.stream.Collectors;

public class Q35 {
    /*
        visited = {
            joe     : "home","about","career",
            james   : "home","cart","maps","home",
            mary    : "home","about","career",
        }

        pattern = {
            "home","about","career": 2,
            "home","cart","maps": 1,
            "home","cart","home": 1
            "home","maps","home": 1
            "cart","maps","home": 1
        }

     */

    final Map<String, Integer> pattern = new HashMap();

    public static void main(String[] args) {
        Q35 sol = new Q35();
        String[] username = {"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
        int[] timestamp = new int[]{527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930};
        String[] website = new String[]{"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};
        System.out.println(sol.mostVisitedPattern(username, timestamp, website));
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, Map<Integer, String>> visited = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            Map<Integer, String> visitedWebsite = visited.getOrDefault(username[i], new HashMap<>());
            visitedWebsite.put(timestamp[i], website[i]);
            visited.put(username[i], visitedWebsite);
        }

        for (Map.Entry<String, Map<Integer, String>> map : visited.entrySet()) {
            List<Integer> keys = map.getValue().keySet().stream().collect(Collectors.toList());
            Collections.sort(keys);
            List<String> websites = new ArrayList<>();
            for (int i : keys)
                websites.add(visited.get(map.getKey()).get(i));
            backTracking(websites, new ArrayList<>(), new HashSet<>());
        }

        List<String> ans = new ArrayList<>();
        int freq = 0;
        for (Map.Entry<String, Integer> map : pattern.entrySet()) {
            if (map.getValue() == freq) {
                if (map.getKey().compareTo(String.join(",", ans)) < 0) {
                    ans = Arrays.asList(map.getKey().split(","));
                }
            } else if (map.getValue() > freq) {
                freq = map.getValue();
                ans = Arrays.asList(map.getKey().split(","));
            }
        }

        return ans;
    }

    private void backTracking(List<String> list, List<String> newList, Set<String> set) {
        if (newList.size() == 3) {
            String key = newList.stream().collect(Collectors.joining(","));
            if (!set.contains(key)) {
                set.add(key);
                pattern.put(key, pattern.getOrDefault(key, 0) + 1);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                newList.add(list.get(i));
                backTracking(list.subList(i + 1, list.size()), newList, set);
                newList.remove(newList.size() - 1);
            }
        }
    }
}
