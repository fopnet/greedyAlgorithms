package greedyAlgorithms.Node;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeMap {
    private int count;
    private Map<Character, TrieNodeMap> children;
    private boolean isEndOfWord;

    public TrieNodeMap() {
        this.children = new HashMap<>();
    }

    /**
     * @return the isEndOfWord
     */
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    /**
     * @param isEndOfWord the isEndOfWord to set
     */
    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    /**
     * @return the data
     */
    public int childrenOccurs() {
        return count;
    }

    void incrementOccurs() { 
        count++;
    }  

    public TrieNodeMap getNode(Character c) {
        return this.children.get(c);
    }

    public TrieNodeMap addChild(char key) {
        TrieNodeMap added = this.children.computeIfAbsent(key, c -> new TrieNodeMap());
        added.incrementOccurs();
        return added;
    }

}