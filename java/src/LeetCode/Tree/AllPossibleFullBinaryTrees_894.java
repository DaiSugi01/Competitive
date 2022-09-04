package LeetCode.Tree;

import LeetCode.Tree.Utuils.Tree;
import LeetCode.Tree.Utuils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees_894 {

    Map<Integer, List<TreeNode>> memo = new HashMap();

    public static void main(String[] args) {
        AllPossibleFullBinaryTrees_894 sol = new AllPossibleFullBinaryTrees_894();
        List<TreeNode> ans = sol.allPossibleFBT(5);
        for (TreeNode t : ans) {
            Tree.printTree(t);
            System.out.println("");
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);

    }
}
