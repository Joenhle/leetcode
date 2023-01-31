import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node,Node> hashMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (hashMap.containsKey(node)){
            return hashMap.get(node);
        }

        Node node1 = new Node(node.val,new ArrayList<>());
        for (Node neighbor : node.neighbors){
            node1.neighbors.add(cloneGraph(neighbor));
        }
        hashMap.put(node,node1);
        return node1;
    }

}
