import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    HashMap<Integer,Integer> hashMap = new HashMap<>();

    int max = 1;
    int pre = 0x3333ffff;

    public void bst(TreeNode root){
        if (root == null)
            return;
        bst(root.left);
        if (root.val!=pre){
            hashMap.put(root.val,1);
        }else {
            int cnt = hashMap.get(root.val);
            max = Math.max(cnt+1,max);
            hashMap.put(root.val,cnt+1);
        }
        pre = root.val;
        bst(root.right);
    }

    public int[] findMode(TreeNode root) {

        List<Integer> arr = new ArrayList<>();
        bst(root);
        for (int i : hashMap.keySet()){
            if (hashMap.get(i)==max){
                arr.add(i);
            }
        }

        int []res = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i){
           res[i] = arr.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
