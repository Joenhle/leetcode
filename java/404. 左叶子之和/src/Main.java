
public class Main {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves_left(TreeNode root,boolean left) {
        if (root==null)
            return 0;
        if (root.left == null && root.right == null && left == true){
            return root.val;
        }
        return sumOfLeftLeaves_left(root.left,true) + sumOfLeftLeaves_left(root.right,false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        return sumOfLeftLeaves_left(root.left, true) + sumOfLeftLeaves_left(root.right, false);
    }

    public static void main(String[] args) {


    }
}
