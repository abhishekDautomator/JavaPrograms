package DataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); //supports smallcase, uppercase, digits and special characters
    boolean isEndOfWord = false;
}
