class Solution:
    def minDistance(self, word1, word2):
        if word1 == '' or word2 == '':
            return len(word2) if word1 == '' else len(word1)
        l1, l2 = len(word1), len(word2)
        dp = [[1000 for _ in range(l2+1)] for _ in range(l1+1)]
        for i in range(l2+1):
            dp[0][i] = i
        for j in range(l1+1):
            dp[j][0] = j
        dp[0][0] = 0
        for i in range(1, l1+1):
            for j in range(1, l2+1):
                ch1, ch2 = word1[i-1], word2[j-1]
                if ch1 == ch2:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        return dp[l1][l2]
    
s = Solution()
print(s.minDistance("dinitrophenylhydrazine", "phenylhydrazine"))