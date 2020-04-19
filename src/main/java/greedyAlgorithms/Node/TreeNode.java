package greedyAlgorithms.Node;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int data;
    
    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }   
    
    public TreeNode(int data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        left = null;
        right = null;
    }
}