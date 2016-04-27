public class StoreQueue {

    private MyHeap priorityQueue;
    private MyLinkedList record;

    /**
     * Construct an empty store queue.
     */
    public StoreQueue() {
        priorityQueue = new MyHeap();
        record = new MyLinkedList();
    }

    /**
     * Construct a non empty store queue.
     * @param p             An array representing the queue, where p[0]
     *                      is the first person and p[length - 1] is the last
     * @param numPeople     Number of people in the queue
     */
    public StoreQueue(Person[] p, int numPeople) {
        priorityQueue = new MyHeap(p, numPeople);
        record = new MyLinkedList();
        fillRecord(p);
    }

    /**
     * Fills the record with a given Person array.
     * @param p             An array representing the queue, where p[0]
     *                      is the first person and p[length - 1] is the last
     */
    private void fillRecord(Person[] p) {
        for (int i = 0; i < p.length; i++) {
            record.insert(p[i]);
        }
    }

    /**
     * Enqueue a person into the store queue.
     * @param person The person object to enqueue
     */
    public void enqueue(Person person) {
        priorityQueue.insert(person);
        record.insert(person);
    }

    /**
     * Dequeue a person from the store queue.
     * @return  A reference to the person who was dequeue,
     *          or null if the queue is empty
     */
    public Person dequeue() {

        try {
            Person oldestPerson = priorityQueue.FindMax();
            priorityQueue.DeleteMax();
            return oldestPerson;
        }

        // The queue is empty
        catch (RuntimeException e) {
            return null;
        }
    }

    /**
     * @return A reference to the first person in the queue,
     * or null if the queue is empty
     */
    public Person firstInQueue() {
        try {
            return priorityQueue.FindMax();
        }

        // The queue is empty
        catch (RuntimeException e) {
            return null;
        }
    }

    /**
     * Returns person in n-1 index.
     * @param n: element number.
     * @return Person found.
     */
    public Person returnNthPersonInRecord(int n) {
        if (n <= 0 || n > record.getSize()) return null;

        Node<Person> current = record.getHead();
        for (int i = 0; i < n - 1; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Deletes person in n-1 index.
     * @param n: element number.
     */
    public void deleteNthPersonFromRecord(int n) {
        if (n <= 0 || n > record.getSize()) return;

        Node<Person> current = record.getHead();
        for (int i = 0; i < n - 1; i++) {
            current = current.next;
        }
        record.delete(current.data);
    }

    /**
     * Returns person with given id.
     * @param id: id number.
     * @return Person found with given id.
     */
    public Person returnPersonFromRecord(int id) {
        return record.find(id);
    }

    /**
     * Deletes person with given id from record.
     * @param id: id number.
     */
    public void deletePersonFromRecord(int id) {
        Person person = record.find(id);
        if (person == null) return;
        record.delete(person);
    }
}
