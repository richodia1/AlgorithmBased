package Google;

public class LinkedListCopy {
   static class Node {
        int data;        // Data of the node
        Node next;       // Reference to the next node in the linked list
        Node arbitrary;  // Reference to a random node in the linked list (arbitrary pointer)

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.arbitrary = null;
        }
    }
    // Function to copy linked list with arbitrary pointer
    public static Node copyLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.data);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }

        // Step 2: Update arbitrary pointers of the copied nodes
        current = head;
        while (current != null) {
            if (current.arbitrary != null) {
                current.next.arbitrary = current.arbitrary.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copied linked lists
        Node newHead = head.next;
        Node original = head;
        Node copied = newHead;

        while (original != null) {
            original.next = original.next.next;
            copied.next = (copied.next != null) ? copied.next.next : null;

            original = original.next;
            copied = copied.next;
        }

        return newHead;
    }

    // Print the linked list for testing
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Setting arbitrary pointers for testing
        head.arbitrary = head.next.next;
        head.next.arbitrary = head;
        head.next.next.arbitrary = head.next.next.next;
        head.next.next.next.arbitrary = head.next;

        System.out.println("Original Linked List:");
        printList(head);

        Node copiedHead = copyLinkedList(head);

        System.out.println("Copied Linked List:");
        printList(copiedHead);
    }
}
