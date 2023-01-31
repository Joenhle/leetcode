class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        ans = ''
        while columnNumber > 0:
            columnNumber -= 1
            temp = columnNumber % 26
            columnNumber = columnNumber // 26
            ans = chr(ord('A') + temp) + ans
        return ans

if __name__ == '__main__':
    s = Solution()
    print(s.convertToTitle(26*26))