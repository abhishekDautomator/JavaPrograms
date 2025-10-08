package DataStructure.Trie;

public class TrieRevision {
    private final TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean preFix(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
