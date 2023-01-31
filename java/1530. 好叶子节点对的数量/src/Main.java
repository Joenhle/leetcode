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

    public static int[] getCount(TreeNode root, int distance){
        if (root == null) return new int[1025];
        if (root.left == null && root.right == null){
            int []res = new int[1025];
            res[1] = 1;
            return res;
        }
        int []cnt = new int[1025];
        int []left = getCount(root.left,distance);
        int []right = getCount(root.right,distance);
        int ans = left[0] + right[0];

        for (int i = 1; left[i] != 0; ++i){
            for (int j = 1; right[j] != 0; ++j){
                if (left[i] + right[j] <= distance)
                    ans++;
            }
        }

        cnt[0] = ans;
        int k = 1;
        for (int i = 1; left[i] != 0; ++i)
            cnt[k++] = left[i] + 1;
        for (int j = 1; right[j] != 0; ++j)
            cnt[k++] = right[j] + 1;
        return cnt;
    }

    public static int countPairs(TreeNode root, int distance) {
        int ans[] = getCount(root,distance);
        return ans[0];
    }

    public static void main(String[] args) {

    }
}
