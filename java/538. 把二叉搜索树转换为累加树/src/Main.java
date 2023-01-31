


public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int ans = 0;

    public void bst(TreeNode root){
        if (root == null)
            return;
        bst(root.right);
        root.val += ans;
        ans = root.val;
        bst(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        bst(root);
        return root;
    }

    public static void main(String[] args) {

    }
}
