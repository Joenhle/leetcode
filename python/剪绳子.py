class Solution:
    def cuttingRope(self, n: int) -> int:
        if n == 0:
            return 0
        dp = [0, 1]
        for i in range(2, n+1):
            dp.append(0)
            for j in range(1, i):
                res = max([dp[i], dp[j] * (i-j), j * (i-j)])
                dp[i] = res
        return dp[n]


if __name__ == "__main__":
    s = Solution()
    print(s.cuttingRope(2))
