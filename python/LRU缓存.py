import colletions

class LinkedHashMap(object):

    class Node(object):
        def __init__(self, key, value, pre_node=None, latter_node=None):
            self.key = key
            self.value = value
            self.pre_node = pre_node
            self.latter_node = latter_node

    def __init__(self, capacity):
        self.items = {}
        self.capacity = capacity
        self.first = None
        self.last = None

    def clear(self):
        self.items.clear()
        self.first = None
        self.last = None

    def remove(self, key):
        if key not in self.items:
            return
        node = self.items[key]
        del self.items[key]
        if self.first == node and self.last == node:
            self.clear()
        elif self.first == node:
            temp = self.first.latter_node
            temp.pre_node = None
            self.first = temp
        elif self.last == node:
            temp = self.last.pre_node
            temp.latter_node = None
            self.last = temp
        else:
            node.pre_node.latter_node = node.latter_node
            node.latter_node.pre_node = node.pre_node
        
    def add(self, key, value):
        self.remove(key)
        new_node = self.Node(key, value)
        if len(self.items) == 0:
            self.items[key] = new_node
            self.first = new_node
            self.last = new_node
        else:
            self.items[key] = new_node
            new_node.latter_node = self.first
            self.first.pre_node = new_node
            self.first = new_node
        
        if len(self.items) > self.capacity:
            self.remove(self.last.key)
        
    def get(self, key):
        if key in self.items:
            self.add(key, self.items[key].value)
            return self.items[key].value
        else:
            return -1
        
class LRUCache:

    def __init__(self, capacity: int):
        self.linkedHashMap = LinkedHashMap(capacity)
    
    def get(self, key):
        return self.linkedHashMap.get(key)

    def put(self, key, value):
        self.linkedHashMap.add(key, value)

# -------------------------------采用colletions.OrderedDict---------------------------------
class LRUCache2(colletions.OrderedDict):

    def __init__(self, capacity):
        super().__init__()
        self.capacity = capacity
    
    def get(self, key):
        if key not in self:
            return -1
        self.move_to_end(key)
        return self[key]
    
    def put(self, key, value):
        if key in self:
            self.move_to_end(key)
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last=False)
