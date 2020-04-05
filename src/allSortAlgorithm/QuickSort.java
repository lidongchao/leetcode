package allSortAlgorithm;

import java.util.Arrays;

/**
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分：
 *   1. 前面 p 到 q-1 之间都是小于 pivot 的，
 *   2. 中间是 pivot，
 *   3. 后面的 q+1 到 r 之间是大于 pivot 的。
 * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，
 * 直到区间缩小为 1，就说明所有的数据都有序了。
 *
 * -- 极客时间《数据结构与算法之美》 12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？
 *
 * 时间复杂度：
 * 最好情况 O(nlogn)
 * 最坏情况 O(n^2)
 * 平均情况 O(nlogn)
 *
 * 空间复杂度：O(1) 属于原地排序算法
 *
 * 是否稳定：否
 *
 */
public class QuickSort extends SortAlgorithm {

    /**
     * 快速排序，升序排序
     * @param a 待排序数组
     * @return 排序后的新数组
     */
    @Override
    public int[] sort(int[] a) {
        if (null == a) return null;

        int n = a.length;
        int[] arr = Arrays.copyOf(a, n);

        if (n <= 1) return arr;

        quickSort(arr, 0, n-1);
        return arr;
    }

    /**
     * 快速排序递归函数
     * @param a 待排序数组
     * @param p 待排序元素在数组的左边界
     * @param r 待排序元素在数组的右边界
     */
    private void quickSort(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }
        // 获取分区点
        int q = partition(a, p, r);
        // 以分区点为界，对左右两部分递归调用本函数
        quickSort(a, p, q-1);
        quickSort(a, q+1, r);
    }

    /**
     * 随机选择一个元素作为 pivot，遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间
     * @param a 待分区数组
     * @param p 待分区元素在数组的左边界
     * @param r 待分区元素在数组的右边界
     * @return 分区点的下标
     */
    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i != j) swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    public String toString() {
        return "Quick Sort";
    }
}
