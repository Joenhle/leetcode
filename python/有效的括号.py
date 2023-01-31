from collections import deque

class Solution:
    def isValid(self, s):
        q = deque()
        q.append(s[0])
        for e in s[1:]:
            if len(q) == 0:
                q.append(e)
                continue
            if e == ')' and q[-1] == '(':
                q.pop()
            elif e == ']' and q[-1] == '[':
                q.pop()
            elif e == '}' and q[-1] == '{':
                q.pop()
            else:
                q.append(e)
        return len(q) == 0

if __name__ == '__main__':
    s = Solution()
    print(s.isValid('()'))