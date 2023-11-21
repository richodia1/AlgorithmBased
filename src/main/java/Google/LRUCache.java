package Google;

import java.util.HashMap;
import java.util.Map;

class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final DoublyLinkedList<K, V> linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.linkedList = new DoublyLinkedList<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            // Move the accessed node to the front (most recently used)
            linkedList.moveToFront(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            // Update the value and move the node to the front
            Node<K, V> node = cache.get(key);
            node.value = value;
            linkedList.moveToFront(node);
        } else {
            // Add a new node to the front
            Node<K, V> newNode = new Node<>(key, value);
            cache.put(key, newNode);
            linkedList.addToFront(newNode);

            // If capacity is exceeded, remove the least recently used node
            if (cache.size() > capacity) {
                Node<K, V> removedNode = linkedList.removeFromEnd();
                cache.remove(removedNode.key);
            }
        }
    }

    // Doubly linked list node
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly linked list to maintain order
    private static class DoublyLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        void addToFront(Node<K, V> node) {
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        void moveToFront(Node<K, V> node) {
            if (node == head) {
                return; // Already at the front
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            if (node == tail) {
                tail = node.prev;
            }

            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        Node<K, V> removeFromEnd() {
            if (tail == null) {
                return null; // List is empty
            }

            Node<K, V> removedNode = tail;

            if (tail.prev != null) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                // List becomes empty
                head = tail = null;
            }

            return removedNode;
        }
    }
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        System.out.println(lruCache.get(2)); // Output: Two
        System.out.println(lruCache.get(1)); // Output: One

        lruCache.put(4, "Four");

        System.out.println(lruCache.get(3)); // Output: null (evicted)
        System.out.println(lruCache.get(2)); // Output: Two
    }
}



