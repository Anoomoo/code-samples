public class Main {
    public static void main(String[] args) {
        SinglyLinkedList numList = new SinglyLinkedList();
        Node nodeA = new Node(66);
        Node nodeB = new Node(99);
        Node nodeC = new Node(44);
        Node nodeD = new Node(95);
        Node nodeE = new Node(42);
        Node nodeF = new Node(17);

        Node nodeG = new Node(10);
        Node nodeH = new Node(14);


        numList.append(nodeB);   // Add 99
        numList.append(nodeC);   // Add 44, make the tail
        numList.append(nodeE);   // Add 42, make the tail

        numList.prepend(nodeA);  // Add 66, make the head

        numList.insertAfter(nodeC, nodeD);  // Insert 95 after 44
        numList.insertAfter(nodeE, nodeF);  // Insert 17 after tail (42)

        // Output list
        System.out.print("List after adding nodes: ");
        numList.printList();

        // Remove the tail node, then the head node
        numList.removeAfter(nodeE);
        numList.removeAfter(null);

        // Output final list
        System.out.print("List after removing nodes: ");
        numList.printList();


        numList.remove(95);
        numList.printList();
        numList.remove(99);
        numList.printList();
        numList.remove(42);
        numList.printList();
        numList.remove(42);
        numList.printList();
        numList.remove(44);
        numList.printList();

        numList.insertAfter(10, 10);
        numList.insertAfter(10, 20);
        numList.insertAfter(20, 30);
        numList.insertAfter(10, 15);
        numList.insertAfter(20, 25);
        numList.insertAfter(30, 40);

        numList.insertAfter(40, 45);

        numList.printList();
    }
}