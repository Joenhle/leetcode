class Solution:
    def maxSubArray(self, nums):
        sums = [0 for i in range(len(nums))]
        for ind, num in enumerate(nums):
            sums[ind] = sums[ind-1] + num if ind >= 1 else num
        least, res = 0, -10**4
        for i in range(len(sums)):
            res = max(res, sums[i] - least)
            least = min(least, sums[i])
        return res

s = Solution()
print(s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))