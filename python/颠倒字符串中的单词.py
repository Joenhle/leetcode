class Solution:
    def reverseWords(self, s):
        return ' '.join(reversed(s.split()))

s = Solution()
print(s.reverseWords("the sky is blue"))