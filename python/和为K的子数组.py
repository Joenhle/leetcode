class Solution:
    def subarraySum(self, nums, k):
        dp, sums, temp, m = [0 for _ in range(len(nums))], [0 for _ in range(len(nums))], 0, {}
        for i, num in enumerate(nums):
            temp += num
            if temp not in m:
                m[temp] = []
            m[temp].append(i)
            sums[i] = temp

        dp[0] = 1 if nums[0] == k else 0

        for i in range(1, len(nums)):
            dp[i] = dp[i-1]
            if sums[i] == k:
                dp[i] += 1
            if sums[i] - k in m:
                for ind in m[sums[i] - k]:
                    if ind < i:
                        dp[i] += 1
                    else:
                        break

        return dp[len(dp)-1]


s = Solution()
print(s.subarraySum([1, -1, 0, 0], 0))
        