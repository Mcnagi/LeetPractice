package problems.other;

import problems.dataStructure.TreeNode;

public class Q0100SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      if (q == null) return true;
      else return false;
    } else if (q == null) return false;
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
