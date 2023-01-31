class Solution:
    def calculate(self, s):
        s = s.replace(' ', '')
        def _calculate(_s):
            if _s[0] == '-':
                _s = '0' + _s
            while _s.find('--') != -1 or _s.find('+-') != -1:
                _s = _s.replace('+-', '-')
                _s = _s.replace('--', '+')
            res = [int(num) for num in _s.replace('+','.').replace('-','.').split('.')]
            for ch in _s:
                if ch == '+':
                    res = [res[0] + res[1]] + res[2:]
                if ch == '-':
                    res = [res[0] - res[1]] + res[2:]
            return str(res[0])
        deque = list()
        for ch in s:
            if ch == ')':
                res = ''
                pre = deque.pop()
                while pre != '(':
                    res = pre + res
                    pre = deque.pop()
                deque += list(_calculate(res))
            else:
                deque.append(ch)
        return int(_calculate(''.join(deque)))

s = Solution()
print(s.calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"))
