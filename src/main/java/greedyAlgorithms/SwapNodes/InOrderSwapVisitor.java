package greedyAlgorithms.SwapNodes;

import greedyAlgorithms.Node.TreeNode;
import greedyAlgorithms.TreeVisitor.InOrderVisitor;

public class InOrderSwapVisitor extends InOrderVisitor {
    private int k;

    boolean[] visited;

    public InOrderSwapVisitor(int k, int nodes) {
        this.k = k;
        this.visited = new boolean[nodes];
    }

    @Override
    protected void _visit(TreeNode node, int h) {
        if (node == null)
            return;

        swap(node, h);

        super._visit(node, h);
    }

    private void swap(TreeNode parent, int h) {

        int parentIdx = parent != null ? parent.data - 1 : -1;
        if (parentIdx >= 0 && isHMultipleOfK(h + 1) && !this.visited[parentIdx]) {
            this.visited[parentIdx] = true;
            TreeNode left = parent.left;
            parent.left = parent.right;
            parent.right = left;
        }
    }

    private boolean isHMultipleOfK(int h) {
        return h % k == 0;
    }
}