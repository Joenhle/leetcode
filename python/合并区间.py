from operator import le


class Solution:
    def merge(self, intervals):
        res = []
        intervals = sorted(intervals)
        temp = intervals[0]
        for left, right in intervals[1:]:
            if left > temp[1]:
                res.append(temp)
                temp = [left, right]
                continue
            if right > temp[1]:
                temp[1] = right
        res.append(temp)
        return res


if __name__ == '__main__':
    intervals = [[1,4],[4,5]]
    s = Solution()
    print(s.merge(intervals))
    