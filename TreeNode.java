/**
 * Represents a node in a binary tree
 * This node is only capable to hold Person data objects
 */
public class TreeNode {

    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    private Person data;

    /**
     * Construcs a TreeNode from a Person.
     * @param data: given Person.
     */
    public TreeNode(Person data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructs a TreeNode from a Person and a parent TreeNode.
     * @param data: given Person
     * @param parent: given TreeNode parent.
     */
    public TreeNode(Person data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    /**
     * Parent Getter.
     * @return TreeNode.
     */
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Parent Setter.
     * @param parent: TreeNode.
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * Left node getter.
     * @return left TreeNode.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Left node setter.
     * @param left: left TreeNode.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Right node getter.
     * @return Right node getter.
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Right node setter.
     * @param right right TreeNode.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Current Data getter.
     * @return Person data.
     */
    public Person getData() {
        return data;
    }

    /**
     * Current Data setter.
     * @param data Person.
     */
    public void setData(Person data) {
        this.data = data;
    }
}
