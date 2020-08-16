package lruCache146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 思路 2：LinkedHashMap
 *
 * 执行用时 :22 ms, 在所有 Java 提交中击败了49.91%的用户
 * 内存消耗 :48.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class LRUCache2 extends LinkedHashMap<Integer, Integer> {

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
    public LRUCache2(int capacity) {
        this(16, capacity);
    }

    public LRUCache2(int initialCapacity, int capacity) {
        super(initialCapacity, 0.8f, true);
        this.capacity = capacity;
    }


    /**
     * 根据 key 在缓存中查询 value
     * 如果命中，返回 value，同时将被访问过的数据移动到链表头部
     * 如果未命中，返回 -1
     * @param key 缓存键
     * @return 缓存值
     */
    public int get(int key) {
        final Integer res = super.get(key);
        if (res == null) {
            return -1;
        } else {
            return res;
        }
    }

    /**
     * 将 key-value 加入缓存
     * @param key 缓存键
     * @param value 缓存值
     */
    public void put(int key, int value) {
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }

    private int capacity;

}
