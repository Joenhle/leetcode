class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        if head is None:
            return None
        if head.val == val:
            return head.next
        pre = head
        next = pre.next
        while next is not None:
            if next.val == val:
                pre.next = next.next
                break
            pre = next
            next = pre.next
        return head