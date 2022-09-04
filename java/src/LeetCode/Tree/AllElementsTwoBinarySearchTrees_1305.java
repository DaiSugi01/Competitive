package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AllElementsTwoBinarySearchTrees_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stream.of(dfs(root1, new ArrayList<>()), dfs(root2, new ArrayList<>())).forEach(ans::addAll);
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> dfs(TreeNode<Integer> root, List<Integer> ans) {
        if (root == null) return ans;

        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);

        return ans;
    }
}
