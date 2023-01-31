import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    public void dfs(TreeNode root){
        if (root == null)
            return;
        arrayList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {

        if (root==null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;

        dfs(root);
        int[] arr = arrayList.stream().mapToInt(k->k).toArray();
        Arrays.sort(arr);
        int min = arr[0];
        for (int i = 1; i < arr.length;++i){
            if (arr[i]!=min)
                return arr[i];
        }
        return -1;
    }



    public static void main(String[] args) {

    }


}
