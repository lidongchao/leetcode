package lfuCache460;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 2：在思路 1 的基础上改进。频率查找表由一个双向链表实现。
 *
 * 执行用时 :19 ms, 在所有 Java 提交中击败了99.74%的用户
 * 内存消耗 :47.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class LFUCache2 {
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
    public LFUCache2(int capacity) {
        this.keyMap = new HashMap<>(capacity);
        this.capacity = capacity;
        this.util = new FreqListUtil();
    }

    public int get(int key) {
        // 根据 key 查询缓存
        final DataNode dataNode = keyMap.get(key);
        // 未命中
        if (null == dataNode) {
            return -1;
        }
        else {
            // key 的访问次数加一
            util.plusOneOnDataNodeFreq(dataNode);
            // 返回缓存值
            return dataNode.value;
        }
    }

    public void put(int key, int value) {
        if (0 == capacity) return;
        final DataNode dataNode = keyMap.get(key);
        // key 已在缓存中
        if (null != dataNode) {
            // 更新 value
            dataNode.value = value;
            // key 的访问次数加一
            util.plusOneOnDataNodeFreq(dataNode);
            return;
        }
        // 缓存已满，需要移除访问次数最少且最不经常使用的记录
        if (capacity == keyMap.size()) {
            final DataNode remove = util.removeDataNode();
            keyMap.remove(remove.key);
        }
        // 更新 keyMap，在双向列表中维护访问次数
        final DataNode newDataNode = new DataNode(key, value);
        keyMap.put(key, newDataNode);
        util.addDataNode(newDataNode);
    }



    private int capacity;
    private Map<Integer, DataNode> keyMap;  // Key : (Value, Freq)
    private FreqListUtil util;

    class DataNode {
        DataNode() {}
        DataNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        @Override
        public String toString() {
            return "DataNode{" +
                    "<" + key +
                    "," + value +
                    ">(" + freq +
                    ")}";
        }

        int key;
        int value;
        int freq;
        FreqNode freqNode;  // 当前节点所在的次数链表
        DataNode prev;  // 当前节点所在的次数链表中的前一个节点
        DataNode post;  // 当前节点所在的次数链表中的后一个节点
    }

    /**
     * 工具类，维护一个双向链表，head 和 tail 为空结点，中间的每一个结点都代表一个次数，从头到尾次数递增
     * 其中每一个次数结点也维护了一个双向链表，存放该次数下的数据结点
     */
    class FreqListUtil {

        FreqListUtil() {
            this.head = new FreqNode();  // 头结点，指示结点
            this.tail = new FreqNode();  // 尾结点，指示结点
            head.post = tail;
            tail.prev = head;
        }

        void printList() {
            FreqNode p = head;
            while (p != tail) {
                System.out.print(p);
                p = p.post;
            }
            System.out.println();
        }

        // 将数据结点的访问次数加一，同时将该数据结点从当前的次数结点移动到下一个次数结点上
        void plusOneOnDataNodeFreq(DataNode dataNode) {
            // 获取该数据结点对应的次数结点
            final FreqNode current = dataNode.freqNode;
            // 如果次数结点的下一个结点不是当前次数加一的关系，就需要新增一个结点
            if (current.post.freq != dataNode.freq + 1) {
                addFreqNode(current, dataNode.freq + 1);
            }

            // 移除数据结点
            removeDataNode(dataNode);
            // 数据结点的访问次数加一
            dataNode.freq++;
            // 将数据结点添加到新的次数结点的链表上
            addDataNode(current.post, dataNode);
        }

        // 数据结点添加到次数结点的链表上
        void addDataNode(FreqNode list, DataNode dataNode) {
            // 头插法
            dataNode.post = list.head.post;
            dataNode.prev = list.head;
            dataNode.post.prev = dataNode;
            dataNode.prev.post = dataNode;
            // 更新数据结点对应的次数结点
            dataNode.freqNode = list;
        }

        // 数据结点添加到次数为 1 的次数结点的链表上
        void addDataNode(DataNode dataNode) {
            // 保证存在次数为 1 的次数结点
            if (head.post.freq != 1) {
                addFreqNode(head, 1);
            }
            addDataNode(head.post, dataNode);
        }

        // 移除数据结点
        void removeDataNode(DataNode dataNode) {
            // 将数据结点从次数结点的链表上移除
            dataNode.prev.post = dataNode.post;
            dataNode.post.prev = dataNode.prev;
            // 如果次数结点为空，则一并将该次数结点移除
            final FreqNode list = dataNode.freqNode;
            if (list.head.post == list.tail) {
                removeFreqNode(list);
            }
        }

        // 移除最久最少访问的数据结点
        DataNode removeDataNode() {
            // 该结点位于第一个次数结点 (head.post) 的尾部 (tail.prev)
            final DataNode last = head.post.tail.prev;
            removeDataNode(last);
            return last;
        }

        // 在指定的次数结点后面新增一个次数结点
        void addFreqNode(FreqNode freqNode, int freq) {
            final FreqNode post = new FreqNode(freq);
            post.prev = freqNode;
            post.post = freqNode.post;
            post.prev.post = post;
            post.post.prev = post;
        }

        // 移除次数结点
        void removeFreqNode(FreqNode list) {
            list.prev.post = list.post;
            list.post.prev = list.prev;
        }

        FreqNode head;
        FreqNode tail;

    }

    class FreqNode {

        FreqNode() {}

        FreqNode(int freq) {
            this.freq = freq;
            head = new DataNode();  // 头结点，指示结点
            tail = new DataNode();  // 尾结点，指示结点
            head.post = tail;
            tail.prev = head;
        }

        @Override
        public String toString() {
            return "DLL{" +
                    "freq=" + freq +
                    '}';
        }

        DataNode head;
        DataNode tail;
        int freq = 0;  // 当前次数结点代表的频次
        FreqNode prev = null;  // 前一个次数结点             this.freq > pref.freq
        FreqNode post = null;  // 后一个次数结点 post.freq > this.freq
    }
}


