class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        temp = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                row, col = j, n-1-i
                temp[row][col] = matrix[i][j]
        for i in range(n):
            for j in range(n):
                matrix[i][j] = temp[i][j]
        return matrix

matrix = [[1,2,3], [4,5,6], [7,8,9]]
s = Solution()
print(s.rotate(matrix))
        
