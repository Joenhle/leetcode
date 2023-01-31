


public class Main {

    class Trie {

        class Node{
            Node childs[] = new Node[26];
            boolean isleaf;
        }

        private Node root = new Node();

        /** Initialize your data structure here. */
        public Trie() {
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insertWithNode(word,root);
        }

        public void insertWithNode(String word,Node node){
            if (node == null)
                return;
            if (word.length()==0){
                node.isleaf = true;
                return;
            }
            int index = getIndexCharacter(word.charAt(0));
            if (node.childs[index] == null){
                node.childs[index] = new Node();
            }
            insertWithNode(word.substring(1),node.childs[index]);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return searchWithNode(word,root);
        }

        public boolean searchWithNode(String word,Node node){
            if (node == null) return false;
            if (word.length() == 0) return node.isleaf;
            int index = getIndexCharacter(word.charAt(0));
            return searchWithNode(word.substring(1),node.childs[index]);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWithNode(prefix,root);
        }

        public boolean startsWithNode(String word,Node node){
            if (node == null) return false;
            if (word.length() == 0) return true;
            int index = getIndexCharacter(word.charAt(0));
            return startsWithNode(word.substring(1),node.childs[index]);
        }

        public int getIndexCharacter(char c){
            return c-'a';
        }

    }

    public static void main(String[] args) {

    }
}
