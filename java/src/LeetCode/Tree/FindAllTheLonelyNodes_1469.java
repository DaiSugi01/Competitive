package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes_1469 {
    public List<Integer> getLonelyNodes(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, false, res);
        return res;
    }

    private void inorder(TreeNode<Integer> root, boolean lonely, List<Integer> res) {
        if (root == null)
            return;

        if (lonely)
            res.add(root.val);

        inorder(root.left, root.right == null, res);
        inorder(root.right, root.left == null, res);
    }

}
