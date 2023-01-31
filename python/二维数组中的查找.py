class Solution:
    def binary_search(self, arr, l, r, x):
        if l <= r:
            mid = int(l + (r-l)/2)
            if arr[mid] == x:
                return mid
            elif arr[mid] < x:
                return self.binary_search(arr, mid+1, r, x)
            else:
                return self.binary_search(arr, l, mid-1, x)
        else:
            return -1

    def findNumberIn2DArray(self, matrix, target) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        n = len(matrix)
        m = len(matrix[0])
        for i in range(n):
            if self.binary_search(matrix[i], 0, m-1, target) != -1:
                return True
        return False


if __name__ == '__main__':
    arr = [
              [1,   4,  7, 11, 15],
              [2,   5,  8, 12, 19],
              [3,   6,  9, 16, 22],
              [10, 13, 14, 17, 24],
              [18, 21, 23, 26, 30]
        ]
    s = Solution()
    print(s.findNumberIn2DArray(arr, 24))
