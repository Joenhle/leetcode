class Solution:
    def findKthLargest(self, nums, k):
        return sorted(nums, reverse=True)[k-1]

if __name__ == '__main__':
    s = Solution()
    print(s.findKthLargest([3,2,3,1,2,4,5,5,6], 4))