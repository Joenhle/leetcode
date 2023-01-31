

public class Main {

    class Trie {


        class Node{
            Node childs[] = new Node[26];
            int value = 0;
            boolean isleaf;
        }

        private Node root = new Node();

        public Trie() {
        }

        public void insert(String word,int value) {
            insertWithNode(word,root,value);
        }

        public void insertWithNode(String word,Node node,int value){
            if (node == null)
                return;
            if (word.length()==0){
                node.isleaf = true;
                node.value = value;
                return;
            }
            int index = getIndexCharacter(word.charAt(0));
            if (node.childs[index] == null){
                node.childs[index] = new Node();
            }
            insertWithNode(word.substring(1),node.childs[index],value);
        }

        public Node getPreRoot(String pre){
            return getPreRootWithNode(pre,root);
        }

        public Node getPreRootWithNode(String pre,Node node){
            if (node == null) return null;
            if (pre.length() == 0)
                return node;
            int index = getIndexCharacter(pre.charAt(0));
            return getPreRootWithNode(pre.substring(1),node.childs[index]);
        }

        public int getSum(Node root){
            if (root == null) return 0;
            int res = root.value;
            for (int i = 0; i < 26; ++i){
                res += getSum(root.childs[i]);
            }
            return res;
        }

        public int getIndexCharacter(char c){
            return c-'a';
        }
    }


    class MapSum {

        Trie trie = new Trie();

        public MapSum() {
        }

        public void insert(String key, int val) {
            trie.insert(key,val);
        }

        public int sum(String prefix) {
            return trie.getSum(trie.getPreRoot(prefix));
        }
    }

    public static void main(String[] args) {

    }
}
