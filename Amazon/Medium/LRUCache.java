import java.util.*;

public class LRUCache {

    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    void remove(Node node) {

        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {

        map.put(node.key, node);

        Node headNext = head.next;

        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }

    public static void main(String[] args) {

        LRUCache obj = new LRUCache(2);

        obj.put(1, 1);
        obj.put(2, 2);

        System.out.println(obj.get(1)); // 1

        obj.put(3, 3);

        System.out.println(obj.get(2)); // -1

        obj.put(4, 4);

        System.out.println(obj.get(1)); // -1
        System.out.println(obj.get(3)); // 3
        System.out.println(obj.get(4)); // 4
    }
}