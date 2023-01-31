class Solution:
    def maxProduct(self, nums):
        def mul(arr):
            temp = 1
            for e in arr:
                temp *= e
            return temp
        
        def maxWithoutZero(arr):
            index = []
            for i, e in enumerate(arr):
                if e < 0:
                    index.append(i)
            if len(index) % 2 == 0:
                return mul(arr)
            res = arr[index[0]]
            if len(arr[:index[-1]]) > 0:
                res = max(res, mul(arr[:index[-1]]))
            if len(arr[index[0]+1:]) > 0:
                res = max(res, mul(arr[index[0]+1:]))
            return res
        arr = []
        flag = False
        res = 0
        for e in nums:
            if e != 0:
                arr.append(e)
            else:
                flag = True
                if len(arr) > 0:
                    res = max(res, maxWithoutZero(arr))
                    arr.clear()
        if flag == False:
            res = maxWithoutZero(nums)
        if len(arr) > 0:
            res = max(res, maxWithoutZero(arr))
        return res

if __name__ == "__main__":
    s = Solution()
    print(s.maxProduct([-2, 0, 9, -1, 2]))