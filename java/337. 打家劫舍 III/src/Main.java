import java.util.HashMap;

public class Main {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int[] rob_dp(TreeNode root){
        if (root == null)
            return new int[2];

        int[] result = new int[2];

        int[] left = rob_dp(root.left);
        int[] right = rob_dp(root.right);

        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int[] result = rob_dp(root);
        return Math.max(result[0],result[1]);
    }

    public static void main(String[] args) {


    }
}
