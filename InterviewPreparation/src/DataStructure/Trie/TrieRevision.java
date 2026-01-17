package DataStructure.Trie;

public class TrieRevision {
    private final TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
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