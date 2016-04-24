import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {

    TreeNode root;
    TreeNode last;
    int size;

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

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Person person) {

        // In case our tree is empty
        if (isEmpty()) {
            root = new TreeNode(person);
        }

        String binaryRepresentationOfNextFreeIndex = Integer.toBinaryString(size + 1);

        // Travel to the last parent node
        TreeNode currentNode = root;
        int stringSize = binaryRepresentationOfNextFreeIndex.length();
        for (int i = 1; i < stringSize - 1; i++) {
            char currentBitAsAscii = binaryRepresentationOfNextFreeIndex.charAt(i);

            // If the bit is 0, we move to the left child, if 1, we move to the right child

            if (currentBitAsAscii == '0') {
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }

        // Create the new node ot insert
        TreeNode newNode = new TreeNode(person, currentNode);

        // Check the last bit and create the new node
        if (binaryRepresentationOfNextFreeIndex.charAt(stringSize - 1) == '0') {
            currentNode.setLeft(newNode);
        }
        else {
            currentNode.setRight(newNode);
        }

        // Update the last pointer and the size of the tree
        last = newNode;
        ++size;

    }

    public void perculateUp() {

        // Start from the last node
        TreeNode currentNode = last;

        // Loop as long as the child is older than its parent and we haven't
        // got to the root

        while (currentNode.getParent() != null &&
                (currentNode.getData().getAge() >
                        currentNode.getParent().getData().getAge())) {

            swapNodes(currentNode, currentNode.getParent());
            currentNode = currentNode.getParent();
        }
    }

    private void swapNodes(TreeNode first, TreeNode second) {
        Person temp = first.getData();
        first.setData(second.getData());
        second.setData(temp);
    }

    // Queue here is just for testing purpose!
    public void printTree(){
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
