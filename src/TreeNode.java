/**
 * Represents a node in a binary tree
 * This node is only capable to hold Person data objects
 */
public class TreeNode {

    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    private Person data;

    // All the methods are pretty straight foreword, some basic constructors
    // with getters and setters

    public TreeNode(Person data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public TreeNode(Person data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }
}
