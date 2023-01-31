


public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode bst(int[] nums,int l,int r){
        if (l > r)
            return null;
        int middle = (l+r)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = bst(nums,l,middle-1);
        root.right = bst(nums,middle+1,r);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums,0,nums.length);
    }

    public static void main(String[] args) {

    }
}
