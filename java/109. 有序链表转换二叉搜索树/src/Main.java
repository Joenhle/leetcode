import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head!=null){
            arr.add(head.val);
            head = head.next;
        }
        return bst(arr.stream().mapToInt(k -> k).toArray(),0,arr.size()-1);
    }

    public static void main(String[] args) {

    }
}
