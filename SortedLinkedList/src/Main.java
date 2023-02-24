public class Main {
    public static void main(String[] args) {
        SortedNumberList list = new SortedNumberList();
        /*
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        list.insertAfter(list.head, node1);
        list.insertAfter(node1, node2);
        list.insertAfter(node2, node3);
        list.insertAfter(node3, node4);
        list.insertAfter(node4, node5);

        System.out.println(list.getNodeAtSortedValue(0).getData());
        */

        list.insert(77);
        list.insert(15);
        list.insert(-42);
        list.insert(63.5);
        list.remove(-42);




        printList(list);

    }

    public static void printList(SortedNumberList list) {
        Node node = list.head;
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}