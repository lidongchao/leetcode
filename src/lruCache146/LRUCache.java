package lruCache146;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：HashMap + Linked = LinkedHashMap
 *
 * 执行用时 :22 ms, 在所有 Java 提交中击败了49.91%的用户
 * 内存消耗 :48.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class LRUCache {

    /**
     * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。
     * 它应该支持以下操作：获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     *
     * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * 进阶:
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param capacity 缓存容量
     */
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 根据 key 在缓存中查询 value
     * 如果命中，返回 value，同时将被访问过的数据移动到链表头部
     * 如果未命中，返回 -1
     * @param key 缓存键
     * @return 缓存值
     */
    public int get(int key) {
        // 根据 key 查询缓存
        Node node = cache.get(key);
        // 未命中
        if (node == null) {
            return -1;
        }
        // 命中
        else {
            // 将被访问过的数据移动到链表头部
            moveFirst(node);
            // 返回缓存值
            return node.value;
        }
    }

    /**
     * 将 key-value 加入缓存
     * @param key 缓存键
     * @param value 缓存值
     */
    public void put(int key, int value) {
        Node node = cache.get(key);
        // key 已在缓存中
        if (node != null) {
            // 更新 value
            node.value = value;
            // 将被访问过的数据移动到链表头部
            moveFirst(node);
            return;
        }
        // 缓存已满，需要移除最不经常使用的记录
        if (cache.size() == capacity) {
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }
        // 将数据加入 cache 和链表头部
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addFirst(newNode);

    }

    // 从链表中删除 node
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 在链表头部插入 node
    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }

    // 将 node 移动到链表头部
    private void moveFirst(Node node) {
        if (head.next == node) return;
        remove(node);
        addFirst(node);
    }

    // Map 存储 key-value 缓存
    private Map<Integer, Node> cache;
    // 容量
    private int capacity;
    // 链表根据访问时间顺序存储 value
    private Node head;
    private Node tail;

    // 存储数据的内部类
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
