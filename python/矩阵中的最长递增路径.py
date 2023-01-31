class Solution:
    def longestIncreasingPath(self, matrix):
        dp = [[0 for j in range(len(matrix[0]))] for i in range(len(matrix))]
        res = 1

        def recursive(matrix, i, j):
            if dp[i][j] != 0:
                return dp[i][j]
            res = 1
            for dx, dy in [[-1, 0],[1, 0],[0, -1],[0, 1]]:
                xx, yy = i + dx, j + dy
                if 0 <= xx < len(matrix) and 0 <= yy < len(matrix[0]) and matrix[i][j] < matrix[xx][yy]:
                    res = max(res, recursive(matrix, xx ,yy) + 1)
            dp[i][j] = res
            return res
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                res = max(res, recursive(matrix, i, j))
        return res

if __name__ == "__main__":
    s = Solution()
    print(s.longestIncreasingPath([[1]]))