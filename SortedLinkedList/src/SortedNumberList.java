
public class SortedNumberList {
    public Node head;
    public Node tail;

    public SortedNumberList() {
        head = null;
        tail = null;
    }

    // Optional: Add any desired private methods here

    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else if (currentNode == tail) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        else {
            Node successor = currentNode.next;
            newNode.next = successor;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            successor.previous = newNode;
        }
    }

    public Node getNodeAtSortedValue(double number) {
        // Gets the node at the position where previous.getData() <= number <= current.getData()
        Node current = head;
        Node previous = head;
        if (head == null) {
            System.out.println("SortedNumberList is empty.");
            return null;
        }
        if (number < head.getData()) {
            System.out.println("Input number is less than the first element of SortedNumberList");
            return null;
        }
        while (current.getNext() != null) {
            current = current.getNext();
            double currentData = current.getData();
            double previousData = previous.getData();
            if (previousData <= number && number <= currentData) {
                break;
            }
            previous = previous.getNext();
        }
        return previous;
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    // Inserts the number into the list in the correct position such that the
    // list remains sorted in ascending order.
    public void insert(double number) {
        Node toInsert = new Node(number);
        Node sortedPos = getNodeAtSortedValue(number);
        if (sortedPos == null) {
            prepend(toInsert);
        } else {
            insertAfter(sortedPos, toInsert);
        }
    }

    // Removes the node with the specified number value from the list. Returns
    // true if the node is found and removed, false otherwise.
    public boolean remove(double number) {
        Node iterator = head;
        boolean removed = false;
        if (head == null) {
            return false;
        }
        if (head.getData() == number) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
            }
            return true;
        }
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            if (iterator.getData() == number) {
                removed = true;
                if (iterator.getNext() == null) {
                    iterator.getPrevious().setNext(null);
                } else {
                    Node next = iterator.getNext();
                    Node prev = iterator.getPrevious();
                    if (prev == null) {
                        this.head = next;
                        iterator.setNext(null);
                    } else {
                        prev.setNext(next);
                        next.setPrevious(prev);
                        iterator.setNext(null);
                        iterator.setPrevious(null);
                    }
                }
                break;
            }
        }
        return removed;
    }
}
