class Solution:

    def exist(self, board, word):
        def dfs(board, word, path, flag, x, y):
            path += board[x][y]
            if path == word:
                return True
            if not word.startswith(path):
                return False
            res = False
            flag[x][y] = 1
            for i, j in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                next_x = x + i
                next_y = y + j
                if 0 <= next_x < len(board) and 0 <= next_y < len(board[0]) and flag[next_x][next_y] == 0:
                    res = res or dfs(board, word, path, flag, next_x, next_y)
            flag[x][y] = 0
            path = path[:-1]
            return res

        flag = [[0 for x in range(len(board[0]))] for i in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(board, word, "", flag, 0, 0):
                    return True
        return False


if __name__ == "__main__":
    s = Solution()
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCCED"
    res = s.exist(board, word)
    print(res)