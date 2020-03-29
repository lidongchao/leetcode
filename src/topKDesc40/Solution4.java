package topKDesc40;

/**
 * 思路 4：堆排序，用大顶堆保存最小的 k 个数，其中堆顶元素是这 k 个数中最大的。
 *
 * 手动实现大顶堆。
 *
 * 执行用时 :10 ms, 在所有 Java 提交中击败了51.79%的用户
 * 内存消耗 :42.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution4 {
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

        // 前 k 个数直接进入大顶堆
        int idx = 0;
        for (int i = 0; i < k; i++) {
            // 往堆中插入一个元素，从下往上进行堆化
            ans[idx] = arr[i];
            int j = idx;
            // j 的父节点是 (j-1)/2，不断与父节点比较是否更大，如果比较成功，则与父节点交换位置，直到到达堆顶或比较失败
            while ((j - 1) >> 1 >= 0 && (ans[j] > ans[(j - 1) >> 1])) {
                swap(ans, j, (j - 1) >> 1);
                j = (j - 1) >> 1;
            }
            idx++;
        }
        // 大顶堆的堆顶元素是堆的最大值
        // 之后的数必须要比最大值要小，才能进入大顶堆，保证大顶堆的数始终是最小的 k 个数
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < ans[0]) {
                // 更小值替换掉堆顶元素，从上往下进行堆化
                ans[0] = arr[i];
                int j = 0;
                // j 的子节点是 2*j+1 和 2*j+2，不断与子节点比较是否更小，如果比较成功，则与其中较大的子节点交换位置，直到到达叶子节点
                // 或比较失败
                while (true) {
                    int bigger = j;
                    if ((j<<1)+1 < k && ans[(j<<1)+1] > ans[j]) bigger = (j<<1)+1;
                    if ((j<<1)+2 < k && ans[(j<<1)+2] > ans[bigger]) bigger = (j<<1)+2;
                    if (bigger == j) break;
                    swap(ans, j, bigger);
                    j = bigger;
                }
            }
        }
        return ans;
    }

    /**
     * 交换数组中下标为 a 和 b 的两个数
     * @param arr 待交换的数所在的数组
     * @param a 待交换的第一个数的下标
     * @param b 待交换的第二个数的下标
     */
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
