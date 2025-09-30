package DataStructure.Trie;

public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null)
                return false;
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abhishek");
        trie.insert("abhinav");
        trie.insert("ajay");

        System.out.println(trie.search("abhishek")); // true
        System.out.println(trie.search("abhi"));     // false
        System.out.println(trie.startsWith("abhi")); // true
    }
}
