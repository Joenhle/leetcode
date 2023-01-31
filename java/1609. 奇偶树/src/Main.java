import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public HashMap<Integer,Integer> hashMap = new HashMap<>();
        boolean res = true;

        public void recursive(TreeNode root, int level){
            if (res == false || root == null) return;
            if (!hashMap.containsKey(level)){
                if ( (level % 2 == 0 && root.val % 2 == 1) || (level % 2 == 1 && root.val % 2 == 0)){
                    hashMap.put(level,root.val);
                }else {
                    res = false;
                }
            }else {
                if (level % 2 == 0){
                    if (root.val % 2 == 1 && root.val > hashMap.get(level)){
                        hashMap.put(level,root.val);
                    }else {
                        res = false;
                    }
                }else {
                    if (root.val % 2 == 0 && root.val < hashMap.get(level)){
                        hashMap.put(level,root.val);
                    }else {
                        res = false;
                    }
                }
            }
            recursive(root.left,level+1);
            recursive(root.right,level+1);
        }

        public boolean isEvenOddTree(TreeNode root) {
            recursive(root,0);
            return res;
        }
    }
}
