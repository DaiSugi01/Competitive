package AlgoBook;

import AlgoBook.Hashing.ChainHash;
import AlgoBook.StringSearch.BoyerMoore;

public class AlgoBookMain {
    public static void main(String[] args) {
        stringSearch();
//        chapter3Hashing();
    }

    private static void chapter3Hashing() {
        ChainHash<Integer, Integer> map = new ChainHash<>(7);
        map.add(10, 46);
        map.add(11, 1);
        map.add(12, 3);
        map.add(13, 4);
        map.add(14, 5);
        map.add(7, 10);
        map.dump();
    }

    public static void stringSearch() {
//        System.out.println(BruteForce.bfMatchLast("ABABCDEFGHABCA", "ABC"));
//        System.out.println(KMP.kmpMatch("ABCFFFABCABDABCFFFABCABCABDABCF", "ABCABCABDABC"));
        System.out.println(BoyerMoore.bmMatch("ABCXDEZCBBACABAC", "ABAC"));
    }
}
