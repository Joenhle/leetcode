

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] find(TreeNode root){
        if (root == null)
            return new int[2];

        if (root.left == null && root.right == null){
            return new int[]{root.val,1};
        }

        int[] left= find(root.left);
        int[] right = find(root.right);

        if (left[1] > right[1]){
            return new int[]{left[0],left[1]+1};
        }
        if (right[1] > left[1]){
            return new int[]{right[0],right[1]+1};
        }
        return new int[]{left[0],left[1]+1};
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        int []result = find(root);
        return result[0];
    }

    public static void main(String[] args) {

    }
}
