import java.awt.print.Book;

public class Main {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode res = null;

    public int bst(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return 0;
        int cnt = 0;
        if (root == p || root == q) cnt++;
        int left = bst(root.left,p,q);
        int right = bst(root.right,p,q);
        if (left == 1 && right == 1){
            res = root;
            return 2;
        }
        return cnt+left+right;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bst(root,p,q);
        return res;
    }


    public static void main(String[] args) {

    }
}
