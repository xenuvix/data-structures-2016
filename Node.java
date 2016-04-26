/** Represents a node in a linked list.
 * A node is characterized by a value (T) and a pointer to another node.
 */
public class Node<T> {
    T data;       	// package-private visibility
    Node<T> next;      	// package-private visibility
    
    /** Constructs a node with the given data.
     * The new node will point to the given node (next).
     */
    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
        
    /** Constructs a node with the given data.
     * The new node will point to null.
     */
    Node(T data) {
        this(data, null);
    }
}
