package greedyAlgorithms.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriNode {

    String data;

    List<TriNode> nodes;

    int descendantsWords = 0;

    public TriNode() {
        this.data = "";
        this.nodes = new ArrayList<>();
        this.descendantsWords = 1;
    }

    public TriNode(String data) {
        this();
        this.data = data;
    }  

    /**
     * @return the descendantsWords
     */
    public int getDescendantsWords() {
        return descendantsWords;
    }

    public void incrementWords() {
        this.descendantsWords++;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @return the nodes
     */
    public List<TriNode> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    /**
     * add the inner list a TriNode
     * 
     * @param node
     */
    public void add(TriNode node) {
        this.nodes.add(node);
    }

    public boolean match(String word) {
        return this.data.compareToIgnoreCase(word) == 0;
    }
}