package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q12 {
    public static void main(String[] args) {
        Q12 sol = new Q12();
        List<Integer> res = sol.partitionLabels("eccbbbbdec");
        for (int n : res) {
            System.out.print(String.valueOf(n) + ", ");
        }
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                map.put(c, new Pair(i, i));
            map.put(s.charAt(i), new Pair(map.get(c).first, i));
        }

        List<Integer> res = new ArrayList<>();
        Pair p = new Pair(0, 0);
        for (int i = 0; i < s.length(); i++) {
            Pair current = map.get(s.charAt(i));

            if (i > p.end) {
                res.add(p.end - p.first + 1);
                p = current;
            }

            if (current.end < p.end)
                continue;

            if (current.end > p.end) {
                p.end = current.end;
                continue;
            }
        }

        res.add(p.end - p.first + 1);
        return res;
    }
    
    class Pair {
        int first;
        int end;

        public Pair(int f, int e) {
            first = f;
            end = e;
        }
    }
}
