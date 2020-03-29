package topKDesc40;

import java.util.Map;
import java.util.TreeMap;

/**
 * 思路 6：用二叉排序树有序保存最小的 k 个数。
 *
 * 利用 TreeMap 实现二叉排序树。
 *
 * 执行用时 :46 ms, 在所有 Java 提交中击败了11.95%的用户
 * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution6 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 限制：
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr 整数数组
     * @param k 最小的个数
     * @return 整数数组中最小的 k 个数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        int[] ans = new int[k];

        // TreeMap 实现二叉排序树，默认升序排序
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // 前 k 个数直接进入 TreeMap
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // TreeMap 的最后一个元素是最大值
        // 之后的数必须要比最大值要小，才能进入 TreeMap，保证 TreeMap 的数始终是最小的 k 个数
        for (int i = k; i < arr.length; i++) {
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > arr[i]) {
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }
        // 输出 TreeMap 中的数
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                ans[i++] = entry.getKey();
            }
        }
        return ans;
    }

}
