class Solution:
    def numDecodings(self, s):
        dp = [0 for _ in range(len(s))]
        if s[0] != '0':
            dp[0] = 1
        for i in range(1, len(s)):
            num1 = 0 if s[i] == '0' else dp[i-1]
            num2 = 0
            if s[i-1] != '0' and 10 <= int(s[i-1] + s[i]) <= 26:
                if i-2 >= 0:
                    num2 = dp[i-2]
                else:
                    num2 = 1
            dp[i] = num1 + num2
        return dp[len(s)-1]        


if __name__ == '__main__':
    s = Solution()
    print(s.numDecodings('0'))