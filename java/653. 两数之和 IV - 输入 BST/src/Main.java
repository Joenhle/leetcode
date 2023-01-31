import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> arr = new ArrayList<>();

    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public boolean smooth_window(int k){
        int l = 0;
        int r = arr.size()-1;
        while (l < r){
            if (arr.get(l) + arr.get(r) == k)
                return true;
            else if (arr.get(l) + arr.get(r) < k)
                l++;
            else
                r--;
        }
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        return smooth_window(k);
    }



    public static void main(String[] args) {

    }
}
