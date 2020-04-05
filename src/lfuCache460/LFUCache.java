package lfuCache460;

import java.util.*;

/**
 * 思路 1：用第一个 HashMap 充当缓存，键为 key，值为 (value, frequency)
 * 第二个 HashMap 充当频率查找表，键为 frequency，值为 [key1, key2, key3 ...]，且维护 key 的插入顺序
 *
 * 执行用时 :57 ms, 在所有 Java 提交中击败了31.17%的用户
 * 内存消耗 :47.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class LFUCache {
    /**
     * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
     *
     * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
     *
     * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，
     * 使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
     *
     * 进阶：
     * 你是否可以在 O(1) 时间复杂度内执行两项操作？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lfu-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param capacity 缓存容量
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyMap = new HashMap<>(capacity);
        this.freqMap = new HashMap<>();
    }

    /**
     * 根据 key 在缓存中查询 value
     * 如果命中：返回 value，key 的访问次数加一
     * 如果未命中，返回 -1
     * @param key 缓存键
     * @return 缓存值
     */
    public int get(int key) {
        // 根据 key 查询缓存
        final Node node = keyMap.get(key);
        // 未命中
        if (null == node) {
            return -1;
        }
        // 命中
        else {
            // key 的访问次数加一
            findAndAdd(key, node);
            // 返回缓存值
            return node.value;
        }
    }

    private void findAndAdd(int key, Node node) {
        final int freq = node.freq;
        freqMap.get(freq).remove(key);
        if (freqMap.get(freq).isEmpty() && freq == minFreq) {
            minFreq = freq + 1;
        }
        node.freq++;
        addFreqMap(key, freq + 1);
    }

    /**
     * 将 key-value 加入缓存
     * @param key 缓存键
     * @param value 缓存值
     */
    public void put(int key, int value) {
        if (0 == capacity) return;
        final Node node = keyMap.get(key);
        // key 已在缓存中
        if (null != node) {
            // 更新 value
            node.value = value;
            // key 的访问次数加一
            findAndAdd(key, node);
            return;
        }
        // 缓存已满，需要移除访问次数最少且最不经常使用的记录
        if (capacity == keyMap.size()) {
            // 这里不需要维护 minFreq，因为最后的 addFreqMap 必定会将 minFreq = 1
            remove();
        }
        // 更新 keyMap 和 freqMap
        keyMap.put(key, new Node(value, 1));
        addFreqMap(key, 1);
    }

    private void addFreqMap(int key, int freq) {
        Queue<Integer> freqQueue = freqMap.get(freq);
        if (null == freqQueue) {
            freqQueue = new ArrayDeque<>();
            freqMap.put(freq, freqQueue);
        }
        freqQueue.add(key);

        if (minFreq > freq) {
            minFreq = freq;
        }
    }

    private void remove() {
        final int key = freqMap.get(minFreq).poll();
        keyMap.remove(key);
    }


    private int capacity;
    private int minFreq = Integer.MAX_VALUE;
    private Map<Integer, Node> keyMap;  // Key : (Value, Freq)
    private Map<Integer, Queue<Integer>> freqMap;  // Freq : [Key1, Key2 ...]

    class Node{
        Node(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "DataNode{" +
                    "value=" + value +
                    ", freq=" + freq +
                    '}';
        }

        private int value;
        private int freq;
    }
}


