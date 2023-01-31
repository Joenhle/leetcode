
public class Main {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    int path = 0;

    public int dfs(TreeNode root){
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int left_path = (root.left!=null && root.val==root.left.val) ? left+1 : 0;
        int right_path = (root.right!=null && root.val == root.right.val) ? right+1 : 0;

        path = Math.max(path,left_path+right_path);
        return Math.max(left_path,right_path);
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    public static void main(String[] args) {

    }


}
