

public class Main {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int pre = 0;
    int ans = 0x7fffffff;


    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        ans = Math.min(ans,Math.abs(root.val-pre));
        pre = root.val;
        inorder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }

    public static void main(String[] args) {

    }
}
