class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        res = None
        def recursive(node):
            if not node:
                return False, False
            l1, l2 = recursive(node.left)
            r1, r2 = recursive(node.right)
            if (l1 and r2) or (l2 and r1) or (node == p and (l2 or r2)) or (node == q and (l1 or r1)):
                nonlocal res
                res = node
                return True, True
            return (l1 or r1 or node == p), (l2 or r2 or node == q)

        def recursive2(node):
            if not node:
                return 0
            left = recursive2(node.left)
            right = recursive2(node.right)
            cnt = 1 if node == p or node == q else 0
            nonlocal res
            if (left == 1 and right == 1) or (cnt == 1 and (left == 1 or right == 1)):
                res = node
            return left + right + cnt

        # recursive(root)
        recursive2(root)
        return res

s = Solution()
n1 = TreeNode(1)
n2 = TreeNode(2)
n1.left = n2

res = s.lowestCommonAncestor(n1, n1, n2)
print(res)
            