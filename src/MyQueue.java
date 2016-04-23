/**
 * Created by Daniel on 23/04/2016.
 */
public class MyQueue {

    private MyLinkedList innerList;

    MyQueue() {
        this.innerList = new MyLinkedList();
    }

    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    public void enqueue(Person person) {
        innerList.insert(person);
    }

    public Person dequeue() {
        return innerList.removeFirst();
    }

}
