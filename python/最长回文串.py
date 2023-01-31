class Solution:
    def longestPalindrome(self, s):
        dp = [0 for _ in range(len(s))]
        dp[0] = 1
        res = [1, s[0]]
        for i in range(1, len(s)):   
            dp[i] = dp[i-1] 
            for j in range(i-dp[i], -1, -1):
                temp = s[j:i+1]
                if temp == temp[::-1] and i-j+1 > dp[i]:
                    dp[i] = i-j+1                
                    res = [dp[i], temp]

        return res[1]

s = Solution()
print(s.longestPalindrome("badad"))

        