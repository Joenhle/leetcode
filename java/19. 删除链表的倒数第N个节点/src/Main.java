import javafx.util.Pair;

import java.util.ArrayList;

public class Main {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


//    ArrayList<ListNode> arrayList = new ArrayList<>();
//
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        while (head!=null){
//            arrayList.add(head);
//            head = head.next;
//        }
//        ListNode pre = arrayList.get(arrayList.size() - n);
//        pre.next = pre.next.next;
//        return arrayList.get(0);
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0){
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
