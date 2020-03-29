package topKDesc40;

/**
 * 思路 2：注意到 arr 数组的每一个元素都不超过 10000，所以直接上计数排序。
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了99.75%的用户
 * 内存消耗 :42.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution2 {
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
        int[] dict = new int[10001];
        // 初始化计数排序数组
        for (int data : arr) {
            dict[data] += 1;
        }
        // 记录已取出多少个最小的数
        int index = 0;
        loop:
        // 从 0 开始顺序遍历直到 10000
        for (int i = 0; i < 10001; i++) {
            // dict[i] 表示 i 出现的次数
            if (0 == dict[i]) continue;
            // 出现多次的话，需要重复存入
            for (int j = 0; j < dict[i]; j++) {
                ans[index++] = i;
                // 达到 k 上限，结束循环并返回
                if (index >= k) break loop;
            }
        }

        return ans;
    }
}
