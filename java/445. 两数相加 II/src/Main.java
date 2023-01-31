public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode recursive(ListNode l1,ListNode l2){
        if (l1 == null && l2 == null) return null;
        ListNode temp = recursive(l1.next,l2.next);
        ListNode root = null;
        if (temp == null){
            root = new ListNode(l1.val+l2.val);
            root.next = null;
        }else {
            root = new ListNode(l1.val+l2.val+temp.val/10);
            temp.val = temp.val%10;
            root.next = temp;
        }
        return root;
    }

    public ListNode modify(ListNode root){
        if (root == null) return null;
        ListNode temp = modify(root.next);
        if (temp == null) return root;
        root.val += temp.val/10;
        temp.val = temp.val%10;
        root.next = temp;
        return root;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null && temp2 != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 != null){
            ListNode cur = l1;
            ListNode pre = null;
            while (cur != null && temp1 != null){
                pre = cur;
                cur = cur.next;
                temp1 = temp1.next;
            }
            pre.next = recursive(cur,l2);
            modify(l1);
            if (l1.val >= 10){
                ListNode root = new ListNode(l1.val/10);
                l1.val = l1.val%10;
                root.next = l1;
                return root;
            }
            return l1;
        }else if (temp2 != null){
            ListNode cur = l2;
            ListNode pre = null;
            while (cur != null && temp2 != null){
                pre = cur;
                cur = cur.next;
                temp2 = temp2.next;
            }
            pre.next = recursive(cur,l1);
            modify(l2);
            if (l2.val >= 10){
                ListNode root = new ListNode(l2.val/10);
                l2.val = l2.val%10;
                root.next = l2;
                return root;
            }
            return l2;
        }else {
            ListNode root = recursive(l1,l2);
            if (root.val >= 10){
                ListNode temp = new ListNode(root.val/10);
                root.val = root.val % 10;
                temp.next = root;
                return temp;
            }
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
