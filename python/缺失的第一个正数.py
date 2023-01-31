class Solution:
    def firstMissingPositive(self, nums):
        def recursive(num):
            temp = nums[num-1]
            nums[num-1] = num
            if 0 < temp <= len(nums):
                if temp == num:
                    return
                recursive(temp)
            

        for i, num in enumerate(nums):
            if 0 < num <= len(nums):
                nums[i] = -1
                recursive(num)
        
        for i, num in enumerate(nums):
            if i+1 != num:
                return i+1

        return len(nums) + 1

if __name__ == '__main__':
    s = Solution()
    print(s.firstMissingPositive([1,2,0]))
