public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode();
//        ListNode cur = head;
//        while (l1!=null || l2!=null){
//            if (l1!=null && l2!=null){
//                if (l1.val <= l2.val){
//                    cur.next = new ListNode(l1.val);
//                    l1 = l1.next;
//                }else {
//                    cur.next = new ListNode(l2.val);
//                    l2 = l2.next;
//                }
//            }else if (l1!=null){
//                cur.next = new ListNode(l1.val);
//                l1 = l1.next;
//            }else {
//                cur.next = new ListNode(l2.val);
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        return head.next;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public static void main(String[] args) {

    }
}
