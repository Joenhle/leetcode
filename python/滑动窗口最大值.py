import heapq
class Solution:
    def maxSlidingWindow(self, nums, k):
        q = [(-nums[i], i) for i in range(k)]
        heapq.heapify(q)
        ans = [-q[0][0]]
        for i in range(k, len(nums)):
            heapq.heappush(q, (-nums[i], i))
            while q[0][1] <= i-k:
                heapq.heappop(q)
            ans.append(-q[0][0])
        return ans
            

if __name__ == '__main__':
    s = Solution()
    print(s.maxSlidingWindow([1,2,3,4,1,2,3], 1))