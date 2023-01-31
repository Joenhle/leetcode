import java.util.ArrayList;
import java.util.List;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> list = new ArrayList<>();

    public void backtracking(TreeNode root,String pre){
        if (root == null) return;;
        if (root.left == null && root.right == null){
            String res = pre + "->" + Integer.valueOf(root.val);
            list.add(res.substring(2));
        }else {
            backtracking(root.left,pre + "->" + Integer.valueOf(root.val));
            backtracking(root.right,pre + "->" + Integer.valueOf(root.val));
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(root,new String());
        return list;
    }

    public static void main(String[] args) {

    }
}
