import java.util.ArrayList;
import java.util.List;

public class Main {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean Symmetric_side(TreeNode a,TreeNode b){
        if (a==null || b==null){
            return a==b;
        }
        return a.val==b.val && Symmetric_side(a.left,b.right) && Symmetric_side(a.right,b.left);
    }



    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return Symmetric_side(root.left,root.right);
    }

    public static void main(String[] args) {

    }



}
