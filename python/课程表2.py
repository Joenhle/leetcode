class Solution:
    def findOrder(self, numCourses, prerequisites):
        res = []
        def dfs(node, s):
            if node in s:
                raise
            if node in res:
                return
            s.add(node)
            for neighbor in arr[node]:
                dfs(neighbor, s)
            res.append(node)
            s.remove(node)
        arr = [[] for _ in range(numCourses)]
        indegree = [0 for _ in range(numCourses)]
        for a, b in prerequisites:
            arr[a].append(b)
            indegree[b] += 1
        for i in range(numCourses):
            if indegree[i] != 0:
                continue
            try:
                dfs(i, set())
            except RuntimeError:
                return []
        if len(res) != numCourses:
            return []
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.findOrder(5, [[1,0],[2,0],[3,1],[3,2],[4,3],[1,4]]))

