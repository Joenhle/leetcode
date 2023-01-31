class Solution:
    def lengthOfLongestSubstring(self, s):
        if len(s) == 0:
            return 0
        m = set()
        m.add(s[0])
        res = 1
        left, right = 0, 1
        while left <= right and right < len(s):
            ch = s[right]
            if ch not in m:
                m.add(ch)
                res = max(res, len(m))
                right += 1
            else:
                m.remove(s[left])
                left += 1
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.lengthOfLongestSubstring("pwwkew"))
