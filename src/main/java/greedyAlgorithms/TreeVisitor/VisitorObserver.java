package greedyAlgorithms.TreeVisitor;

import greedyAlgorithms.Node.TreeNode;

public interface VisitorObserver {

    public void visited(TreeNode node, int h);
}