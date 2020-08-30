package lruCache146;

import utils.AssertUtils;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        AssertUtils.assertEquals(1, cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        AssertUtils.assertEquals(-1, cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        AssertUtils.assertEquals(-1, cache.get(1));       // 返回 -1 (未找到)
        AssertUtils.assertEquals(3, cache.get(3));       // 返回  3
        AssertUtils.assertEquals(4, cache.get(4));       // 返回  4

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, 0.8f, true);

        LRUCache2 cache2 = new LRUCache2( 2 /* 缓存容量 */ );
        cache2.put(1, 1);
        cache2.put(2, 2);
        AssertUtils.assertEquals(1, cache2.get(1));       // 返回  1
        cache2.put(3, 3);    // 该操作会使得密钥 2 作废
        AssertUtils.assertEquals(-1, cache2.get(2));       // 返回 -1 (未找到)
        cache2.put(4, 4);    // 该操作会使得密钥 1 作废
        AssertUtils.assertEquals(-1, cache2.get(1));       // 返回 -1 (未找到)
        AssertUtils.assertEquals(3, cache2.get(3));       // 返回  3
        AssertUtils.assertEquals(4, cache2.get(4));       // 返回  4

    }

}
