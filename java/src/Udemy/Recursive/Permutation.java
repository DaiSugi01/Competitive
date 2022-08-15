package Udemy.Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        List<List<Integer>> list = permutation(new ArrayList<>(Arrays.asList(1, 2, 3)));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<List<Integer>> permutation(List<Integer> elements) {
        if (elements.size() <= 1)
            return new ArrayList<>(new ArrayList<>(Arrays.asList(elements)));

        List<List<Integer>> res = new ArrayList<>();
        /*
            rest[:i] + first[0] + rest[i:]
            [2, 3], [3, 2]      -> 1,2,3    1,3,2
            [2]                 -> 2,1,
         */
        for (List<Integer> perm : permutation(elements.subList(1, elements.size()))) {
            for (int i = 0; i < elements.size(); i++) {
                res.add(concatArr(elements.subList(0, 1), perm, i));
            }
        }

        return res;
    }

    private static List<Integer> concatArr(List<Integer> first, List<Integer> rest, int i) {
        List<Integer> dist = new ArrayList<>();
        dist.addAll(rest.subList(0, i));
        dist.addAll(first.subList(0, 1));
        dist.addAll(rest.subList(i, rest.size()));
        return dist;
    }
}
