package SingleLinkedList;

public class SingleLinkedList {

    LinkedListNode head;
     public class LinkedListNode {
        LinkedListNode next;
         private int size;
        Object data;
        LinkedListNode(Object data){
            this.data = data;
            next = null;
    }
         /**
          * Inserting new node at the end of the linked list
          *
          * @param  - represent the node item to be added to the linked list
          */
         // sorted merged list
         public  LinkedListNode SortedMergedLinkedList( LinkedListNode A, LinkedListNode B){
             if(A == null) return B;
             if(B== null) return A;
             if((int)A.data < (int)B.data){
                 A.next = SortedMergedLinkedList(A.next,B);
                 return A;
             }else{
                 B.next = SortedMergedLinkedList(A,B.next);
                 return B;
             }
         }
         // reverse a linkedList node
         public LinkedListNode reversedLinkedList( LinkedListNode node){
          if(node == null || node.next == null) return node;
             LinkedListNode p = reversedLinkedList(node.next);
             node.next.next = node;
             node.next = null;
             return p;
         }
    public void insertLast(int item){
        LinkedListNode newNode = new LinkedListNode(item);
        LinkedListNode currentNode = head;
        if(head == null){
            head = newNode;
            head.next = null;
            size++;
        }else {
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = null;
            size++;
        }

    }
         /**
          * Adding node at the first location of the linked list
          *
          * @param item - represent item of the node to be added to LL
          */
         public void insertFirst(String item){
             LinkedListNode currentNode = new LinkedListNode(item);
             currentNode.next = head;
             head = currentNode;
             size++;
         }
         /**
          * Adding node at the nth location of the linked list
          *
          * @param item - represent the item of the node to be added to the list
          * @param position - position at which the node is to be added
          */
         public void insertAtPosition(int position, int item){
             LinkedListNode newNode = new LinkedListNode(item);
             LinkedListNode currentNode = head;
             if(head !=null && position <= size) {
                 for (int i = 1; i < position; i++) {
                     currentNode = currentNode.next;
                 }
                 newNode.next = currentNode.next;
                 currentNode.next = newNode;
                 size++;
             }else {
                 System.out.println("list size overflow");
             }
         }
         /**
          * Deleting the first node from the list
          */
         public void deleteFirstNode() {
             if(head != null){
                 head = head.next;
                 this.size--;
             }else{
                 System.out.println("Linked list is empty");
             }
         }
         /**
          * Deleting the last node from the list
          */
         public void deleteLastNode() {
             LinkedListNode currentNode = head;
             if(size == 1){
                 head = null;
                 size = 0;
             }else{
                 LinkedListNode prevNode = null;
                 while (currentNode.next != null) {
                     prevNode = currentNode;
                     currentNode = currentNode.next;
                 }
                 prevNode.next = null;
                 this.size--;
             }
         }

         /**
          * Deleting the node from the nth location in the list
          *
          * @param position - location of the node to be deleted
          */
         public void deleteNthNode(int position) {
             if (position <= this.size && head != null) {
                 LinkedListNode currentNode = head;
                 LinkedListNode prevNode = null;
                 for (int i = 0; i < position; i++) {
                     prevNode = currentNode;
                     currentNode = currentNode.next;
                 }
                 prevNode.next = currentNode.next;
                 this.size--;
             }else{
                 System.out.println("No node exist at location: "+position);
             }
         }

         /**
          * Find if the node exist in the list
          *
          * @param item - item to be found in the list
          *
          */
         public void findNode(String item) {
             LinkedListNode node = head;
             boolean found = false;
             for(int i=0;i<size; i++){
                 if(node.data.equals(item)){
                     System.out.println("Item "+item+" was found at location "+i+" in the linked list");
                     found = true;
                 }
                 node = node.next;
             }

             if(!found)
                 System.out.println("Item "+item+" was not found in the Linked list");
         }

         /**
          * Find the node item located at a specific location
          *
          * @param location - Find item at location
          *
          */
         public void findNodeAt(int location) {
             LinkedListNode node = head;
             if(head !=null && location<= size){
                 for(int i=0;i<location;i++){
                     node = node.next;
                 }
                 System.out.println("Node item at location "+location+" is "+node.data);
             }
         }

         /**
          * Find the item at the last location
          *  07069797791
          */
         public void findLastNode() {
             LinkedListNode node = head;
             if(head != null){
                 for(int i=0;i<size-1;i++){
                     node = node.next;
                 }
                 System.out.println("Node item at last location is "+node.data);
             }
         }


         /**
          * Printing all the items in the list
          */
         public void printNodes() {
             if (this.size < 1)
                 System.out.println("There are no nodes in the linked list");
             else {
                 LinkedListNode current = head;
                 for (int i = 0; i < this.size; i++) {
                     System.out.println("Node " + current.data + " is at location " + i);
                     current = current.next;
                 }
             }
         }

         /**
          * Obtain the current size of the list
          * @return
          */
         public int getListSize(){
             return size;
         }
       // public static void main(String[] args) {
           /* int[] arr1 = new int[] {1, 3, 5, 6};
            int[] arr2 = new int[] {2, 4, 6, 20, 34};
            LinkedListNode list_head1 = LinkedList.create_linked_list(arr1);
            System.out.print("Original1: ");
            LinkedList.display(list_head1);

            LinkedListNode list_head2 = LinkedList.create_linked_list(arr2);
            System.out.print("Original2: ");
            LinkedList.display(list_head2);

            System.out.println("\nMerged:");

            LinkedListNode newHead = merge_sorted(list_head1, list_head2);
            LinkedList.display(newHead);
            ?
            */
        //}
    }
}
