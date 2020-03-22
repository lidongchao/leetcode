package topKDesc;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 思路 3：堆排序，用大顶堆保存最小的 k 个数，其中堆顶元素是这 k 个数中最大的。
 *
 * 利用优先队列(默认小顶堆) + 自定义降序比较器实现大顶堆。
 *
 * 执行用时 :17 ms, 在所有 Java 提交中击败了38.72%的用户
 * 内存消耗 :43.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution3 {
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

        // 优先队列默认为小顶堆，因此通过自定义降序比较器转换为大顶堆
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        // 前 k 个数直接进入大顶堆
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        // 大顶堆的堆顶元素是堆的最大值
        // 之后的数必须要比最大值要小，才能进入大顶堆，保证大顶堆的数始终是最小的 k 个数
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.remove();
                pq.offer(arr[i]);
            }
        }
        // 输出大顶堆中的数
        int i = 0;
        for (int num : pq) {
            ans[i++] = num;
        }
        return ans;
    }

}
