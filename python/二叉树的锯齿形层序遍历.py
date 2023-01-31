from re import S


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def zigzagLevelOrder(self, root):
        m = {}
        def recursive(root, depth):
            if not root:
                return
            if depth not in m:
                m[depth] = []
            m[depth].append(root.val)
            recursive(root.left, depth + 1)
            recursive(root.right, depth + 1)
        recursive(root, 0)
        res = []
        for i in range(len(m)):
            if i % 2 == 1:
                m[i].reverse()
            res.append(m[i])
        return res

s = Solution()
n1 = TreeNode(3)
n2 = TreeNode(9)
n3 = TreeNode(20)
n4 = TreeNode(15)
n5 = TreeNode(7)

n1.left, n1.right = n2, n3
n3.left, n3.right = n4, n5
print(s.zigzagLevelOrder(n1))