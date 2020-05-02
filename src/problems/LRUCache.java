package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * 146. LRU Cache
 * Medium
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(2);
    *
    *cache.put(1,1);
    *cache.put(2,2);
    *cache.get(1);       // returns 1
    *cache.put(3,3);    // evicts key 2
    *cache.get(2);       // returns -1 (not found)
    *cache.put(4,4);    // evicts key 1
    *cache.get(1);       // returns -1 (not found)
    *cache.get(3);       // returns 3
    *cache.get(4);       // returns 4
 */
public class LRUCache {

    private final Map<Integer, Node> cache;
    private final Node head, tail;
    private final int capacity;

    public LRUCache(int capacity) {
        final int initialCapacity = capacity + 1;
        cache = new HashMap<>(initialCapacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        final Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        final Node node = cache.getOrDefault(key, new Node(key, value));
        node.value = value;

        cache.put(key, node);
        moveToHead(node);

        if (cache.size() > capacity) {
            final Node evicted = evictLast();
            cache.remove(evicted.key);
        }
    }

    private void moveToHead(final Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        head.next.prev = node;
        node.next = head.next;

        node.prev = head;
        head.next = node;
    }

    private Node evictLast() {
        final Node tailPrev = tail.prev;
        tailPrev.prev.next = tail;
        tail.prev = tailPrev.prev;
        return tailPrev;
    }
}

class Node {

    int key, value;
    Node prev, next;

    Node() {
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
