package greedyAlgorithms.Trie;

import greedyAlgorithms.Node.TrieNodeMap;

public class ContactMap {
    private TrieNodeMap trieMap;

    public ContactMap() {
        this.trieMap = new TrieNodeMap();
    }

    boolean add(String word) {
        TrieNodeMap current = this.trieMap;

        for (char c : word.toCharArray()) 
            current = current.addChild(c);

        current.setEndOfWord(true);
        return true;
    }

    public TrieNodeMap find(String word) {
        TrieNodeMap current = trieMap;
        for (char c : word.toCharArray()) {
             current = current.getNode(c);
            if (current == null) return current;
        }
        return  current;
    }

    public int findOccurs(String word) {
        TrieNodeMap rNode = find(word);
        return rNode != null ? rNode.childrenOccurs() : 0;
    }

}