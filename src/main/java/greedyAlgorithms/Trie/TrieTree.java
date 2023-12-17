package greedyAlgorithms.Trie;

import greedyAlgorithms.Node.TriNode;

/**
* https://en.wikipedia.org/wiki/Trie
* 
* T9 Algorithm/Word Trie
A Trie is a multiway tree that can be used to store dictionaries. There are several uses for this data structure. One of them is the word completion look up that most cell phone text message applications use. 
* This was originally used for the T9 algorithm for supporting SMS text messaging on numeric pad phones.
* http://bearcave.com/software/java/t9/index.html
*/
public class TrieTree {
    private TriNode trie;

    public TrieTree() {
        this.trie = new TriNode();
    }

    public boolean add(String word) {
        TriNode refNode = this.findRefNode(word, true);

        if (refNode.getData().matches(word)) {
            return false;
        } else {
             addPartialWord(refNode, word, refNode.getData().length() + 1);
            return true;
        }
    }

    private TriNode findRefNode(String word, boolean isIncDescendants) {
        TriNode refNode = this.trie;

        int level = 1;
        while (!refNode.getNodes().isEmpty() && level <= word.length()) {
            String levelWord = word.substring(0, level);
            TriNode next = refNode.getNodes().stream().filter(n -> n.match(levelWord)).findAny().orElse(null);
            if (next == null) {
                break;
            } else {
                refNode = next;
                if (isIncDescendants && level < word.length())
                    refNode.incrementWords();
                level++;
            }
        }

        return refNode;
    }

    private TriNode addPartialWord(TriNode refNode, String word, int level) {
        String newData = word.substring(0, level);
        TriNode newNode = new TriNode(newData);
        refNode.add(newNode);
        if (level < word.length()) {
            return addPartialWord(newNode, word, ++level);
        } else 
            return newNode;
    }

    public TriNode find(String word) {
        TriNode refNode = this.findRefNode(word, false);
        return refNode.match(word) ? refNode : null;
    }

    public int findOccurs(String word) {
        TriNode rNode = find(word);
        return rNode != null ? rNode.getDescendantsWords() : 0;
    }

}
