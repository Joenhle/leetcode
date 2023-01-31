class Solution:
    def combinationSum(self, candidates, target):
        def back_forward(candidates, target, arr, sum, res, index):
            if sum > target:
                return
            if sum == target:
                res.append(arr.copy())
            for i in range(index, len(candidates)):
                arr.append(candidates[i])
                back_forward(candidates, target, arr, sum + candidates[i], res, i)
                arr.pop()
        res = []
        back_forward(candidates, target, [], 0, res, 0)
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.combinationSum([2], 1))