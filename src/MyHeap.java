public class MyHeap {

    private MyBinaryTree heapBinaryTree;

    public MyHeap(Person[] p, int numPeople) {

        // Run heapify algorithm on each node except of the leaves, O(N)
        for (int i = (numPeople / 2) - 1; i >= 0; i--) {
            heapify(p, i);
        }

        // Convert the array into a binary tree, O(N)
        heapBinaryTree = new MyBinaryTree(p);
    }

    public Person FindMax() {
        if (!heapBinaryTree.isEmpty()) {
            return heapBinaryTree.root.getData();
        }
        throw new IndexOutOfBoundsException("There are no people in this heap");
    }

    public void insert(Person p) {
        heapBinaryTree.insert(p);
        heapBinaryTree.perculateUp();
    }

    public void DeleteMax() {


    }

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

        // If a child is older, we make a swap and make a recurssive call

        if (oldestPerson != index) {

            // Swap the two persons

            Person temp = persons[index];
            persons[index] = persons[oldestPerson];
            persons[oldestPerson] = temp;

            heapify(persons, oldestPerson);
        }
    }

    public void printHeap() {
        heapBinaryTree.printTree();
    }

    private static int getLeftChildIndex(Person[] persons, int index) {
        return ((index + 1) * 2) - 1;
    }

    private static int getRightChildIndex(Person[] persons, int index) {
        return (index + 1) * 2;
    }

    private boolean indexInsideArray(Person[] persons, int index) {
        return index <= persons.length - 1;
    }
}
