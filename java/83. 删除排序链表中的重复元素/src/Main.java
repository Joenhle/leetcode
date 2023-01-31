public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = deleteDuplicates(head.next);
        if (temp == null) return head;
        if (head.val == temp.val){
            return temp;
        }
        head.next = temp;
        return head;
    }

    public static void main(String[] args) {

    }
}
