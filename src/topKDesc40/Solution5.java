package topKDesc40;

/**
 * 思路 5：快排算法实现 topN
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了99.71%的用户
 * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution5 {
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

        int n = k-1;
        int p = 0, q, r = arr.length-1;
        // 不断查找分区点是不是第 k 个数，对应下标 n=k-1
        while (true) {
            // 查找一个分区点
            q = partition(arr, p, r);
            // 恰好是第 k 个数，结束
            if (q == n) break;
            // 分区点更大，在分区点的左边继续查找
            if (q > n) {
                r = q-1;
            }
            // 分区点更小，在分区点的右边继续查找
            else {
                p = q+1;
            }
        }

        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    /**
     * 快排算法的 partition 函数
     * 随机选择一个元素作为 pivot，遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间
     * @param arr 待分区数组
     * @param p 待分区元素在数组的左边界
     * @param r 待分区元素在数组的右边界
     * @return 分区点的下标
     */
    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, r, i);
        return i;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
