public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = swapPairs(head.next.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = next;
        return temp;
    }

    public static void main(String[] args) {

    }
}
