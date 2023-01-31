class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head):
        if head is None or head.next is None:
            return False
        slow = head.next
        fast = slow.next
        while slow != None and fast != None:
            if slow == fast:
                return True
            slow = slow.next
            fast = fast.next
            if fast is None:
                break
            fast = fast.next
        return False