public class Main {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode second_root = fast;
        while (true){
            if (slow.next.next == null){
                fast.next = null;
                slow.next = second_root;
                break;
            }else {
                slow.next = slow.next.next;
            }
            if (fast.next.next == null){
                fast.next = null;
                slow.next = second_root;
                break;
            }else {
                fast.next = fast.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
