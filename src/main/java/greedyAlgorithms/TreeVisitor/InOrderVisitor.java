package greedyAlgorithms.TreeVisitor;

import java.util.ArrayList;
import java.util.List;

import greedyAlgorithms.Node.TreeNode;

public class InOrderVisitor implements Visitor {
    private List<Integer> result = new ArrayList<>();

    private VisitorObserver observer;

    public InOrderVisitor() {
        this.observer = null;
    }

    public InOrderVisitor(VisitorObserver observer) {
        this.observer = observer;
    }

    @Override
    public int[] visit(TreeNode node) {
        _visit(node, 0);
        return this.result.stream().mapToInt(i -> i).toArray();
    }

    protected void _visit(TreeNode node, int h) {
        if (node == null)
            return;

        _visit(node.left, h + 1);

        notifyVisit(node, h);

        _visit(node.right, h + 1);
    }

	public void notifyVisit(TreeNode node, int h) {

        if (this.observer != null) {
            observer.visited(node, h);
        }

        result.add(node.data);
	}

    

}