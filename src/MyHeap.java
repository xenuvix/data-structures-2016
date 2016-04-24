/**
 * Represents a max binary heap of objects of type Person.
 * The persons are organized by their age, i.e the oldest person will be
 * at the root of this heap.
 */
public class MyHeap {

    /**
     * This heap is implemented as a binary tree to allow dynamic resize
     * with expected complexity.
     */
    private MyBinaryTree heapBinaryTree;

    /**
     * Construct a binary heap from array of Person objects.
     *
     * @param p         The given array to be transformed into a binary heap
     * @param numPeople The number of objects in the array (size of the array)
     */
    public MyHeap(Person[] p, int numPeople) {

        // Run heapify algorithm on each node except of the leaves, O(N)
        for (int i = (numPeople / 2) - 1; i >= 0; i--) {
            heapify(p, i);
        }

        // Convert the array into a binary tree, O(N)
        heapBinaryTree = new MyBinaryTree(p);
    }

    /**
     * Find the oldest person in the heap.
     *
     * @return A reference to the oldest person in the heap
     */
    public Person FindMax() {
        if (!heapBinaryTree.isEmpty()) {
            return heapBinaryTree.root.getData();
        }
        throw new IndexOutOfBoundsException("There are no people in this heap");
    }

    /**
     * Inserts a person into the heap, in it's correct place
     * according to it's age.
     *
     * @param p A reference to the person to be inserted into the heap
     */
    public void insert(Person p) {
        heapBinaryTree.insert(p);
        heapBinaryTree.perculateUp();
    }

    /**
     * Delete the oldest person in the heap, while keeping the heap well organized.
     */
    public void DeleteMax() {

        heapBinaryTree.swapRootAndLastNode();
        heapBinaryTree.removeLastNode();
        heapBinaryTree.heapify();
    }

    /**
     * This function takes an array representation of a heap and a index which
     * beneath it the function assume that the heap is organized, and make the
     * correct arrangement of the array including the given index using recursion.
     *
     * @param persons The array representing the heap
     * @param index   The function assume that from this index, the array
     *                is organized as a binary heap
     */
    private void heapify(Person[] persons, int index) {

        // Get the indexes of the left and right childes

        int leftChildIndex = getLeftChildIndex(persons, index);
        int rightChildIndex = getRightChildIndex(persons, index);

        // Check if one of the childes is older than the index

        int oldestPerson = index;

        if (indexInsideArray(persons, leftChildIndex)) {
            if (persons[leftChildIndex].getAge() >=
                    persons[index].getAge()) {
                oldestPerson = leftChildIndex;
            }
        }

        if (indexInsideArray(persons, rightChildIndex)) {
            if (persons[rightChildIndex].getAge() >=
                    persons[oldestPerson].getAge()) {
                oldestPerson = rightChildIndex;
            }
        }

        // If a child is older, we make a swap and make a recursive call

        if (oldestPerson != index) {

            // Swap the two persons

            Person temp = persons[index];
            persons[index] = persons[oldestPerson];
            persons[oldestPerson] = temp;

            heapify(persons, oldestPerson);
        }
    }

    /**
     * For testing purpose only.
     */
    public void printHeap() {
        heapBinaryTree.printTree();
    }

    /**
     * Helper method to get the left child index inside a array representation
     * of a binary heap.
     */
    private static int getLeftChildIndex(Person[] persons, int index) {
        return ((index + 1) * 2) - 1;
    }

    /**
     * Helper method to get the right child index inside a array representation
     * of a binary heap.
     */
    private static int getRightChildIndex(Person[] persons, int index) {
        return (index + 1) * 2;
    }

    /**
     * Helper method to determine if the given index is inside the given array.
     */
    private boolean indexInsideArray(Person[] persons, int index) {
        return index <= persons.length - 1;
    }
}
