package greedyAlgorithms.Trie;

import greedyAlgorithms.Node.TrieNodeMap;

public class TrieMap {
    private TrieNodeMap trieMap;

    public TrieMap() {
        this.trieMap = new TrieNodeMap();
    }

   public  boolean add(String word) {
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