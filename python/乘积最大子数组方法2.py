class Solution:
    def maxProduct(self, nums):
        dp_max = [0 for _ in range(len(nums))]
        dp_min = [0 for _ in range(len(nums))]
        dp_max[0], dp_min[0] = nums[0], nums[0]
        for i in range(1, len(nums)):
            dp_max[i] = max(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i], nums[i])
            dp_min[i] = min(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i], nums[i])
        return max(dp_max)

if __name__ == '__main__':
    s = Solution()
    print(s.maxProduct([-2, 0, -1]))