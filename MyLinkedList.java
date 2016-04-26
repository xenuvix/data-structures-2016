public class MyLinkedList {
    // Pointer to head of the list
	private Node<Person> head;

    // Pointer to last element of the list.
    private Node<Person> last;

    // Size of current LinkedList
    private int size;

    /**
     * Construct an empty list.
     */
	public MyLinkedList()
    {
        head = null;
        last = null;
        size = 0;
	}

    /**
     * Inserts Person p at the end of the list in O(1)
     * @param p: Person to append.
     */
	public void insert(Person p)
    {
		if( head == null)
        {
            head = new Node<>(p, null);
            last = head;
        }
		else
		{
			last.next = new Node<>(p, null);
            last = last.next;
		}
        size++;
	}

    /**
     * Finds a person with given id in list in O(n)
     * @param id: id to find.
     * @return: Person with found id. If not found, return null.
     */
	public Person find(int id)
    {
        Node<Person> cur  = head;
        while (cur != null) {
            if (cur.data.getId() == id)
                return cur.data;
        }

        // Person with correct id wasn't found.
        return null;
	}

    /**
     * Deletes given Person p from list in O(n)
     * @param p: Person to delete.
     */
	public void delete(Person p)
    {
        if(head == null)
            throw new RuntimeException("List is empty.");

        if (head.data.equals(p))
        {
            head = head.next;
            return;
        }

        Node<Person> cur  = head;
        Node<Person> prev = null;

        while (cur != null && !cur.data.equals(p))
        {
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            throw new RuntimeException("Element to delete not found.");

        //delete cur node
        prev.next = cur.next;
        size--;
	}

    /**
     * Returns head of list for iteration.
     * @return Node<Person<>
     */
    public Node<Person> getHead() {
        return head;
    }

    /**
     * Returns current size of LinkedList.
     * @return int of size
     */
    public int getSize() {
        return size;
    }

}
