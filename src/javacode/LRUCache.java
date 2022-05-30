package javacode;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value)Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 */
public class LRUCache {
    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    /**
     *  虚拟头、尾，方便操作，不存数值
     */
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        insertHead(node);
        return node.value;
    }

    /**
     * 移除 node 节点
     * node节点前后相连
     */
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    /**
     * 移至虚拟头后的一个节点
     * @param node
     */
    private void insertHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void removeTail() {
        Node realTail = tail.prev;
        removeNode(realTail);
        map.remove(realTail.key);
    }

    public void put(int key, int value) {
        if (capacity < 1) {
            throw new RuntimeException("缓存容量小于1");
        }
        if (map.get(key) != null) {
            map.get(key).setValue(value);
            get(key);
        } else {
            while (map.size() >= capacity) {
                removeTail();
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertHead(node);
        }
    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        print(lruCache);
        lruCache.get(1);
        lruCache.put(1,5);
        print(lruCache);
        lruCache.put(1,2);
        print(lruCache);
        lruCache.get(2);
        print(lruCache);
    }
    static void print(LRUCache lruCache){
        Node node = lruCache.head.next;
        while (node.next != null) {
            System.out.print(String.format("{key=%s, value=%s} ", node.key, node.value));
            node = node.next;
        }
        System.out.println("");
    }
}
