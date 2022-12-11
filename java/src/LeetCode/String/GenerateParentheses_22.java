package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper("", 0, 0, n);
        return res;
    }


    private void helper(String soFar, int open, int close, int n) {
        if (soFar.length() == n * 2) {
            res.add(soFar);
            return;
        }

        if (open < n)
            helper(soFar + "(", open + 1, close, n);
        if (close < open)
            helper(soFar + ")", open, close + 1, n);
    }
}
