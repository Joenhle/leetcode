import java.util.ArrayList;
import java.util.List;

public class Main {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

    List<Integer> list = new ArrayList<>();

    public void bst(TreeNode root){
        if (root == null)
            return;
        bst(root.left);
        list.add(root.val);
        bst(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        return list.get(k-1);
    }

    public static void main(String[] args) {

    }
}
