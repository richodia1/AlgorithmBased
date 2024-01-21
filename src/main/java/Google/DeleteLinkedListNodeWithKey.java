package Google;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class DeleteLinkedListNodeWithKey {
    public ListNode deleteNode(ListNode head, int key) {
        // Handle the case where the head itself contains the key
        if (head != null && head.val == key) {
            return head.next;
        }

        ListNode prev = null;
        ListNode current = head;

        // Traverse the list to find the node with the given key
        while (current != null && current.val != key) {
            prev = current;
            current = current.next;
        }

        // If the key is found, update the pointers to delete the node
        if (current != null) {
            prev.next = current.next;
        }

        return head;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        DeleteLinkedListNodeWithKey deleteNode = new DeleteLinkedListNodeWithKey();
        System.out.println("Original List:");
        deleteNode.printList(head);

        int keyToDelete = 4;
        head = deleteNode.deleteNode(head, keyToDelete);

        System.out.println("List after deleting node with key " + keyToDelete + ":");
        deleteNode.printList(head);
    }
}
