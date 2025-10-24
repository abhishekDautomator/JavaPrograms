package DataStructure.Trie;

public class TrieNode {
    TrieNode[] children = new TrieNode[26]; //small case a-z
    boolean isEndOfWord = false;
}
