package DataStructure.Trie;

public class WildCardSearchUsingTrie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEndOfWord = true;
    }

    public boolean searchWithWildcard(String pattern) {
        return searchHelper(pattern, 0, root);
    }

    private boolean searchHelper(String pattern, int index, TrieNode node) {
        if (node == null) return false;
        if (index == pattern.length()) return node.isEndOfWord;

        char ch = pattern.charAt(index);

        if (ch == '?') {
            for (TrieNode child : node.children) {
                if (searchHelper(pattern, index + 1, child)) return true;
            }
        } else if (ch == '*') {
            // Try skipping '*'
            if (searchHelper(pattern, index + 1, node)) return true;
            // Try consuming one character
            for (TrieNode child : node.children) {
                if (searchHelper(pattern, index, child)) return true;
            }
        } else {
            int i = ch - 'a';
            return searchHelper(pattern, index + 1, node.children[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        WildCardSearchUsingTrie trie = new WildCardSearchUsingTrie();
        trie.insert("abacus");
        trie.insert("abandon");
        trie.insert("absolute");
        trie.insert("abstract");

        System.out.println(trie.searchWithWildcard("ab?ndon")); // true
        System.out.println(trie.searchWithWildcard("ab*te"));   // true
        System.out.println(trie.searchWithWildcard("ab*z"));    // false
    }
}
