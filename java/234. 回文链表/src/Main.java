public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverse(ListNode node){
        if (node == null) return null;
        ListNode pre = reverse(node.next);
        node.next = null;
        if (pre != null){
            pre.next = node;
        }
        return node;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null){
            reverse(slow.next);
            slow.next = null;
        }else{
            fast = fast.next;
            reverse(slow.next.next);
            slow.next = null;
        }
        while (head != null && fast != null){
            if (head.val != fast.val) return false;
            head = head.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
