package sample;

import java.util.*;

public class Y2 {
    /*
        C1: [P1, P2, P1, P3, P1, P2, P1]
     */

    public static void main(String[] args) {
        Y2 sol = new Y2();
        System.out.println(sol.findSeq(new String[][]{
                new String[]{"T1", "C1", "P1"},
                new String[]{"T2", "C1", "P2"},
                new String[]{"T3", "C1", "P1"},
                new String[]{"T4", "C1", "P3"},
                new String[]{"T5", "C1", "P1"},
                new String[]{"T6", "C1", "P1"},
                new String[]{"T7", "C1", "P3"},
                new String[]{"T8", "C1", "P1"},
                new String[]{"T9", "C1", "P1"},
                new String[]{"T10", "C1", "P3"},
        }));
    }

    private List<String> findSeq(String[][] list) {
        Arrays.sort(list, (s1, s2) -> s1[0].compareTo(s2[0]));
        Map<String, List<String>> map = new HashMap<>();
        for (String[] data : list) {
            List<String> l = map.getOrDefault(data[1], new ArrayList<>());
            l.add(data[2]);
            map.put(data[1], l);
        }

        Map<String, Integer> pageFreq = new HashMap<>();
        for (List<String> l : map.values()) {
            if (l.size() < 3) continue;
            for (int i = 0; i < l.size() - 2; i++) {
                String key = l.get(i) + "," + l.get(i + 1) + "," + l.get(i + 2);
                pageFreq.put(key, pageFreq.getOrDefault(key, 0) + 1);
            }
        }

        int max = 0;
        String pages = "";
        for (Map.Entry<String, Integer> m : pageFreq.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                pages = m.getKey();
            } else if (m.getValue() == max) {
                max = m.getValue();
                if (pages.isBlank())
                    pages = m.getKey();
                else
                    pages = pages.compareTo(m.getKey()) < 0 ? pages : m.getKey();
            }
        }

        return new ArrayList<>(Arrays.asList(pages.split(",")));
    }
}
