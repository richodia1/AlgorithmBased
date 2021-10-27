package codebyteinterview;
/*
Problem Statement ##
Given the head of a Singly LinkedList, reverse the LinkedList.
Write a function to return the new head of the reversed LinkedList.

 */
public class ReverseLinkedList {

    class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    public static ListNode reverse(ListNode head) {
        ListNode current = head; // current node that we will be processing
        ListNode previous = null; // previous node that we have processed
        ListNode next = null; // will be used to temporarily store the next node

        while (current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            previous = current; // before we move to the next node, point previous to the current node
            current = next; // move on the next node
        }
        // after the loop current will be pointing to 'null' and 'previous' will be the new head
        return previous;
    }

    public static ListNode reversed(ListNode head) {
        ListNode next = null;
        ListNode previous = null;
        ListNode current = head;
        while (current != null){
            next = current.next; // the temp
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    /*
    Problem Statement#
    Given the head of a LinkedList and two positions ‘p’ and ‘q’,
    reverse the LinkedList from position ‘p’ to ‘q’.

     */
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q)
            return head;

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
        // 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;
    }

/*
Problem Statement#
Given the head of a LinkedList and a number ‘k’,
reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

 */
public static ListNode reverse(ListNode head, int k) {
    if (k <= 1 || head == null)
        return head;

    ListNode current = head, previous = null;
    while (true) {
        ListNode lastNodeOfPreviousPart = previous;
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse 'k' nodes
        for (int i = 0; current != null && i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the previous part
        if (lastNodeOfPreviousPart != null)
            lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means we are changing the first node (head) of the LinkedList
            head = previous;

        // connect with the next part
        lastNodeOfSubList.next = current;

        if (current == null) // break, if we've reached the end of the LinkedList
            break;
        // prepare for the next sub-list
        previous = lastNodeOfSubList;
    }

    return head;
}

/*
Reverse alternating K-element Sub-list (medium)#
Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public static ListNode reverseThis(ListNode head, int k) {
    if (k <= 1 || head == null)
        return head;

    ListNode current = head, previous = null;
    while (current != null) { // break if we've reached the end of the list
        ListNode lastNodeOfPreviousPart = previous;
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse 'k' nodes
        for (int i = 0; current != null && i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the previous part
        if (lastNodeOfPreviousPart != null)
            lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means we are changing the first node (head) of the LinkedList
            head = previous;

        // connect with the next part
        lastNodeOfSubList.next = current;

        // skip 'k' nodes
        for (int i = 0; current != null && i < k; ++i) {
            previous = current;
            current = current.next;
        }
    }

    return head;
}

/*
Rotate a LinkedList (medium)#
Given the head of a Singly LinkedList and a number ‘k’,
rotate the LinkedList to the right by ‘k’ nodes.
 */
public static ListNode rotate(ListNode head, int rotations) {
    if (head == null || head.next == null || rotations <= 0)
        return head;

    // find the length and the last node of the list
    ListNode lastNode = head;
    int listLength = 1;
    while (lastNode.next != null) {
        lastNode = lastNode.next;
        listLength++;
    }

    lastNode.next = head; // connect the last node with the head to make it a circular list
    rotations %= listLength; // no need to do rotations more than the length of the list
    int skipLength = listLength - rotations;
    ListNode lastNodeOfRotatedList = head;
    for (int i = 0; i < skipLength - 1; i++)
        lastNodeOfRotatedList = lastNodeOfRotatedList.next;

    // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
    head = lastNodeOfRotatedList.next;
    lastNodeOfRotatedList.next = null;
    return head;
}

}
