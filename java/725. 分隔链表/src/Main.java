public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode temp = root;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        int avg = len/k;
        int left = avg%k;
        ListNode[] ans = new ListNode[avg];
        ans[0] = root;
        temp = root;
        int cnt = 1;
        int i = 1;
        while (temp != null){
            if (cnt == k) break;
            if (i == avg + (left > 0 ? 1 : 0)){
                left--;
                ans[cnt++] = temp.next;
                temp.next = null;
                temp = ans[cnt-1];
                i = 1;
            }else {
                ++i;
                temp = temp.next;
            }
        }
        return ans;
    }

}
