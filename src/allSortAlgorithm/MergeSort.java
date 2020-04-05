package allSortAlgorithm;

import java.util.Arrays;

/**
 * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
 *
 * -- 极客时间《数据结构与算法之美》 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？
 *
 * 时间复杂度：
 * 最好情况 O(nlogn)
 * 最坏情况 O(nlogn)
 * 平均情况 O(nlogn)
 *
 * 空间复杂度：O(n) 不属于原地排序算法
 *
 * 是否稳定：是
 */
public class MergeSort extends SortAlgorithm {

    /**
     * 归并排序，升序排序
     * @param a 待排序数组
     * @return 排序后的新数组
     */
    @Override
    public int[] sort(int[] a) {
        if (null == a) return null;

        int n = a.length;
        int[] arr = Arrays.copyOf(a, n);

        if (n <= 1) return arr;

        mergeSort(arr, 0, n-1);
        return arr;
    }

    /**
     * 归并排序递归函数
     * @param a 待排序数组
     * @param p 待排序元素在数组的左边界
     * @param r 待排序元素在数组的右边界
     */
    private void mergeSort(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 获取待排序元素的中间位置，将给下标从 p 到 r 之间的数组排序这个问题，转化为两个子问题
        final int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        // 当下标从 p 到 q 和从 q+1 到 r 这两个子数组都排好序之后，我们再将两个有序的子数组合并在一起，
        // 这样下标从 p 到 r 之间的数据就也排好序了。
        merge(a, p, q, r);
    }

    /**
     * 数组 a 的前半部分 [p, q] 和后半部分 [q+1, r] 各自有序，合并成有序的 [p, r]
     * @param a 待排序数组
     * @param p 前半部分有序元素在数组的左边界
     * @param q 前半部分有序元素在数组的右边界
     * @param r 后半部分有序元素在数组的右边界
     */
    private void merge(int[] a, int p, int q, int r) {
        int[] mergeZone = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                mergeZone[k++] = a[i++];
            } else {
                mergeZone[k++] = a[j++];
            }
        }
        while (i <= q) {
            mergeZone[k++] = a[i++];
        }
        while (j <= r) {
            mergeZone[k++] = a[j++];
        }

        System.arraycopy(mergeZone, 0, a, p, mergeZone.length);
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
