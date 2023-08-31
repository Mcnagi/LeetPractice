package problems;

public class Q0101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null) return root.right == null;
        else if (root.right == null) return false;

        if (root.left.val != root.right.val) return false;

        return isSymmetric(new TreeNode(root.left.val, root.left.left, root.right.right))
                && isSymmetric(new TreeNode(root.left.val, root.left.right, root.right.left));
    }
}
