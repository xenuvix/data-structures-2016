import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a binary tree with additional features specifically
 * for a binary heap.
 * The tree is indexed based on breadth-first order.
 * Note that this tree is only capable of holding Person data objects
 */
public class MyBinaryTree {

    TreeNode root;
    TreeNode last;
    int size;

    /**
     * Construct a binary tree from an array representation of a binary heap.
     *
     * @param binaryTreeArrayRepresentation Array representation of a binary heap.
     */
    public MyBinaryTree(Person[] binaryTreeArrayRepresentation) {

        // Create a temporary array to allow the construction of the tree
        // Java will initiate each of the object to null by default
        TreeNode[] nodesTreeOrder = new TreeNode[binaryTreeArrayRepresentation.length + 1];

        // Create the the nodes inside the temp array, O(N).
        for (int i = 0; i < binaryTreeArrayRepresentation.length; i++) {
            nodesTreeOrder[i + 1] = new TreeNode(binaryTreeArrayRepresentation[i]);
        }

        // Set the proper links between the nodes, O(N)
        for (int i = 1; i < nodesTreeOrder.length; i++) {

            int parentIndex = i / 2;
            int leftChildIndex = i * 2;
            int rightChildIndex = (i * 2) + 1;

            // Check that we have a parent node
            if (parentIndex > 0) {
                nodesTreeOrder[i].setParent(nodesTreeOrder[i / 2]);
            }

            // Set left child
            if (leftChildIndex < nodesTreeOrder.length) {
                nodesTreeOrder[i].setLeft(nodesTreeOrder[leftChildIndex]);
            }

            // Set right child
            if (rightChildIndex < nodesTreeOrder.length) {
                nodesTreeOrder[i].setRight(nodesTreeOrder[rightChildIndex]);
            }
        }

        // Set the root of this binary tree
        root = nodesTreeOrder[1];

        // Set the last node of this binary tree
        last = nodesTreeOrder[nodesTreeOrder.length - 1];

        // Set the size for this binary tree
        size = binaryTreeArrayRepresentation.length;
    }

    /**
     * @return True if the binary tree is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert a Person object into the binary tree after the last current object.
     *
     * @param person A reference to the person object to be inserted
     */
    public void insert(Person person) {

        // In case our tree is empty
        if (isEmpty()) {
            root = new TreeNode(person);
        }

        // Get the parent node for our new node
        TreeNode parentOfNodeToInsert = getNodeAtIndex((size + 1) / 2);

        // Create the new node to insert
        TreeNode newNode = new TreeNode(person, parentOfNodeToInsert);

        // Check the last bit and create the new node
        if (null == parentOfNodeToInsert.getLeft()) {
            parentOfNodeToInsert.setLeft(newNode);
        } else {
            parentOfNodeToInsert.setRight(newNode);
        }

        // Update the last pointer and the size of the tree
        last = newNode;
        ++size;

    }

    /**
     * Moves up the last element in the tree as long as his age is greater
     * than his parent age.
     */
    public void perculateUp() {

        // Start from the last node
        TreeNode currentNode = last;

        // Loop as long as the child is older than its parent and we did not
        // arrive to the root node

        while (currentNode.getParent() != null &&
                (currentNode.getData().getAge() >
                        currentNode.getParent().getData().getAge())) {

            swapNodes(currentNode, currentNode.getParent());
            currentNode = currentNode.getParent();
        }
    }

    /**
     * Swap two nodes in the tree.
     */
    private void swapNodes(TreeNode first, TreeNode second) {
        Person temp = first.getData();
        first.setData(second.getData());
        second.setData(temp);
    }

    /**
     * Swap the root node and the last node in the tree.
     */
    void swapRootAndLastNode() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "The tree is empty, cannot replace first and last elements");
        }

        swapNodes(root, last);
    }

    /**
     * Removes the last node from the tree
     */
    void removeLastNode() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "The tree is empty, cannot remove the last element");
        }

        // Remove the last node from the tree

        TreeNode lastParent = last.getParent();

        // Check if last is the left or right child of his parent
        if (lastParent.getLeft() == last) {
            lastParent.setLeft(null);
        } else {
            lastParent.setLeft(null);
        }

        last.setParent(null);

        // Update tree size
        --size;

        // Update last
        last = getNodeAtIndex(size);
    }

    /**
     * Finds the node at a given index with complexity of O(log(n))
     *
     * @param index The given index in the tree to be found
     * @return A reference to the specific node
     */
    TreeNode getNodeAtIndex(int index) {

        String binaryRepresentationOfIndex =
                Integer.toBinaryString(index);

        // Travel to the index

        TreeNode currentNode = root;
        int stringSize = binaryRepresentationOfIndex.length();
        for (int i = 1; i < stringSize; i++) {
            char currentBitAsAscii = binaryRepresentationOfIndex.charAt(i);

            // If the bit is 0, we move to the left child, if 1, we move to the right child

            if (currentBitAsAscii == '0') {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return currentNode;
    }

    /**
     * Same as the heapify method in MyHeap class, this time implemented
     * on a binary tree
     */
    void heapify() {

        TreeNode currentNode = root;
        TreeNode leftChild = currentNode.getLeft();
        TreeNode rightChild = currentNode.getRight();

        while (
                (null != leftChild) ||
                        (null != rightChild)
                ) {

            TreeNode largest = currentNode;

            if (largest.getData().getAge() < leftChild.getData().getAge()) {
                largest = leftChild;
            }

            if (largest.getData().getAge() < rightChild.getData().getAge()) {
                largest = rightChild;
            }

            if (largest == currentNode) {
                break;
            } else {
                swapNodes(currentNode, largest);
                currentNode = largest;
            }

            // Update left and right child for the iteration
            leftChild = currentNode.getLeft();
            rightChild = currentNode.getRight();
        }
    }

    /**
     * Purely for testing purpose!
     */
    public void printTree() {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                if (currentNode.getLeft() != null) {
                    nextLevel.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    nextLevel.add(currentNode.getRight());
                }
                System.out.print(currentNode.getData().getAge() + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();

        }
    }
}
