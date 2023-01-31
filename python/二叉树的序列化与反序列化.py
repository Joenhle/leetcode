import json
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    def serialize(self, root):
        arr = {}
        def _serialize(root, k):
            if not root:
                return 
            arr[k] = root.val
            _serialize(root.left, 2*k+1)
            _serialize(root.right, 2*k+2)
            return
        
        _serialize(root, 0)
        return json.dumps(arr)

    def deserialize(self, data):
        m = json.loads(data)
        def _deserialize(k):
            if str(k) not in m:
                return None
            root = TreeNode(m[str(k)])
            root.left = _deserialize(2*k+1)
            root.right = _deserialize(2*k+2)
            return root
        return _deserialize(0)

n1 = TreeNode(1)
n2 = TreeNode(2)
n3 = TreeNode(3)
n4 = TreeNode(4)
n5 = TreeNode(5)
n1.left = n2
n1.right = n3
n3.left = n4
n3.right = n5

c = Codec()
root = c.deserialize(c.serialize(n1))
print(root)
