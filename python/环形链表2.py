class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head):
        if head is None or head.next is None:
            return None
        slow, fast = head.next, head.next.next
        while slow != None and fast != None and slow != fast:
            slow = slow.next
            fast = fast.next
            if fast != None:
                fast = fast.next
        if slow == None or fast == None:
            return None
        begin = head
        while begin != slow:
            begin = begin.next
            slow = slow.next
        return begin

if __name__ == '__main__':
    s = Solution()
    print(s.detectCycle())