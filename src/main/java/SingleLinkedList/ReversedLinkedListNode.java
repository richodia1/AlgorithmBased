package SingleLinkedList;

public class ReversedLinkedListNode {

    public static void main(String[] args){
        SingleLinkedListNode  head = new SingleLinkedListNode(2);
        head.next = new SingleLinkedListNode(4);
        head.next.next = new SingleLinkedListNode (6);
        head.next.next.next = new SingleLinkedListNode (8);
        head.next.next.next.next = new SingleLinkedListNode (10);

        SingleLinkedListNode  result = ReversedLinkedListNode.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }

    }
    public static SingleLinkedListNode reverse(SingleLinkedListNode head){
        SingleLinkedListNode current = head;
        SingleLinkedListNode previous = null;
        SingleLinkedListNode next = null;
        while (current != null){
             next = current.next;
             current.next = previous;
             previous = current;
             //
             current = next;
        }

        return previous;
    }
    public static SingleLinkedListNode reverse2(SingleLinkedListNode head){
        SingleLinkedListNode current = head;
        SingleLinkedListNode next = null;
        SingleLinkedListNode previous = null;
        while (current != null){
            next = head.next;
            head.next = previous;
            previous = current;

            current = next;
        }
        return previous;
    }
}
