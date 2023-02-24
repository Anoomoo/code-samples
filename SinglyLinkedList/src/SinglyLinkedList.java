class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    public Node head;
    public Node tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else if (currentNode == tail) {
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public boolean remove(int data) {
        if (this.head == null) {
            return false;
        }

        if (head == tail) {
            if (head.data == data) {
                head = null;
                tail = null;
            }
            return true;
        }

        Node cur = this.head;
        Node prev = this.head;
        while (cur.next != null) {
            if (cur.data == data) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        if (cur.next == null && cur.data == data) {
            tail = prev;
        }
        if (cur.data == data) {
            if (head == cur) {
                this.head = cur.next;
            } else {
                prev.next = cur.next;
            }
        }
        return true;
    }

    public void insertAfter(int dataBefore, int dataAfter) {
        Node newNode = new Node(dataAfter);
        Node cur = head;

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        if (head.next == null) {
            tail = newNode;
        }

        while (cur != null) {
            if (cur.data == dataBefore) {
                break;
            }
            cur = cur.next;
        }


        newNode.next = cur.next;
        cur.next = newNode;

    }

    public void removeAfter(Node currentNode) {
        if (currentNode == null && head != null) {
            // Special case: remove head
            Node succeedingNode = head.next;
            head = succeedingNode;
            if (succeedingNode == null) {
                // Last item was removed
                tail = null;
            }
        }
        else if (currentNode.next != null) {
            Node succeedingNode = currentNode.next.next;
            currentNode.next = succeedingNode;
            if (succeedingNode == null) {
                // Remove tail
                tail = currentNode;
            }
        }
    }
}
