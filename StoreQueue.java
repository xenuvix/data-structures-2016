public class StoreQueue {

    private MyHeap priorityQueue;

    /**
     * Construct an empty store queue.
     */
    public StoreQueue() {
        priorityQueue = new MyHeap();
    }

    /**
     * Construct a non empty store queue.
     * @param p             An array representing the queue, where p[0]
     *                      is the first person and p[length - 1] is the last
     * @param numPeople     Number of people in the queue
     */
    public StoreQueue(Person[] p, int numPeople) {
        priorityQueue = new MyHeap(p, numPeople);
    }

    /**
     * Enqueue a person into the store queue.
     * @param person The person object to enqueue
     */
    public void enqueue(Person person) {
        priorityQueue.insert(person);
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

    public Person returnNthPersonInRecord(int n) {

    }

    public void deleteNthPersonFromRecord(int n) {
    }

    public Person returnPersonFromRecord(int id) {

    }

    public void deletePersonFromRecord(int id) {
    }
}
