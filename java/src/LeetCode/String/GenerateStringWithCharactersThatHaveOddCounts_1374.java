package LeetCode.String;

public class GenerateStringWithCharactersThatHaveOddCounts_1374 {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return "a".repeat(n - 1) + "b";
        } else {
            return "a".repeat(n);
        }
    }
}
