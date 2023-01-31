class Solution:
    def longestValidParentheses(self, s):
        if len(s) == 0:
            return 0
        temp, res, stack, kset = 0, 0, [], set()
        for ind, ch in enumerate(s):
            if ch == '(':
                stack.append((ind, '('))
            else:
                if len(stack) != 0 and stack[len(stack)-1][1] == '(':
                    kset.add(stack.pop()[0]) 
                    kset.add(ind)
                else:
                    stack.append((ind, ')'))
        
        for i in range(len(s)):
            if i in kset:
                temp += 1
                res = max(res, temp)
            else:
                temp = 0
        return res

s = Solution()
print(s.longestValidParentheses("()))()()()"))