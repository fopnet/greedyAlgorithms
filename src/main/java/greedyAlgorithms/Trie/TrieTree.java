package greedyAlgorithms.Trie;

import greedyAlgorithms.Node.TriNode;

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