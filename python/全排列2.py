class Solution:
    def permuteUnique(self, nums):
        res_set = set()
        res = list(list())
        def recursive(i, s, temp):
            if i >= len(nums) and str(temp) not in res_set:
                res.append(temp.copy())
                res_set.add(str(temp))
                return
            for e in s:
                temp[i] = nums[e]
                c = s.copy()
                c.remove(e)
                recursive(i+1, c, temp)
        recursive(0, set(range(len(nums))), [0 for _ in range(len(nums))])
        return res
if __name__ == '__main__':
    s = Solution()
    print(s.permuteUnique([1]))
        