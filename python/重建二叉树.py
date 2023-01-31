class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:

    def recursive(self, preorder, inorder, index_map):
        if len(inorder) == 0:
            return None
        min_index = 0
        for i, v in enumerate(inorder):
            if index_map[v] < index_map[inorder[min_index]]:
                min_index = i
        node = TreeNode(inorder[min_index])
        node.left = self.recursive(preorder, inorder[:min_index], index_map)
        node.right = self.recursive(preorder, inorder[min_index+1:], index_map)
        return node

    def buildTree(self, preorder, inorder):
        if len(preorder) == 0:
            return None
        index_map = {}
        for i, v in enumerate(preorder):
            index_map[v] = i
        root = TreeNode(preorder[0])
        root.left = self.recursive(preorder, inorder[:inorder.index(preorder[0])], index_map)
        root.right = self.recursive(preorder, inorder[inorder.index(preorder[0])+1:], index_map)
        return root


if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    s = Solution()
    root = s.buildTree(preorder, inorder)
    print(root)