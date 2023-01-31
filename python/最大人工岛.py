class Solution:

    def __init__(self):
        self.arr = []
        self.index = 0

    def dfs(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or self.m[i][j][0] != -1 or grid[i][j] == 0:
            return
        self.m[i][j][0] = 0
        self.arr.append((i, j))
        for dx, dy in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
            x, y = i + dx, j + dy
            self.dfs(grid, x, y)    

    def largestIsland(self, grid):
        res = 0
        self.m = [[[-1, -1] for i in range(len(grid))] for j in range(len(grid[0]))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    self.dfs(grid, i, j)
                    for x, y in self.arr:
                        self.m[x][y] = (len(self.arr), self.index)
                    self.index += 1
                    res = max(res, len(self.arr))
                    self.arr.clear()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    temp = 1
                    key = set()
                    for dx, dy in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                        x, y = i + dx, j + dy    
                        if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and self.m[x][y][0] > 0 and not self.m[x][y][1] in key:
                            key.add(self.m[x][y][1])
                            temp += self.m[x][y][0]
                    res = max(res, temp)
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.largestIsland([[1]]))
    
