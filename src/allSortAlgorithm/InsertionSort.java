package allSortAlgorithm;

import java.util.Arrays;

/**
 * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束。
 *
 * -- 极客时间《数据结构与算法之美》 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？
 *
 * 时间复杂度：
 * 最好情况 O(n)
 * 最坏情况 O(n^2)
 * 平均情况 O(n^2)
 *
 * 空间复杂度：O(1) 属于原地排序算法
 *
 * 是否稳定：是
 *
 */
public class InsertionSort extends SortAlgorithm {

    /**
     * 插入排序，升序排序
     * @param a 待排序数组
     * @return 排序后的新数组
     */
    @Override
    public int[] sort(int[] a) {
        if (null == a) return null;

        int n = a.length;
        int[] arr = Arrays.copyOf(a, n);

        if (n <= 1) return arr;

        // 外层循环 n-1 次，初始已排序区间只有一个元素
        // i 是已排序区间和未排序区间的分界点下标，[0,i-1] 属于已排序区间，[i,n-1] 属于未排序区间
        for (int i = 1; i < n; i++) {
            // 保存待排序的元素
            int tmp = arr[i];
            // 从右侧开始遍历已排序区间，找到待排序元素能够插入的位置
            int j = i-1;
            for (; j >= 0; j--) {
                if (tmp >= arr[j]) break;  // 找到该位置
                arr[j+1] = arr[j];  // 移动数据，腾出空位
            }
            arr[j+1] = tmp;  // 插入待排序元素
        }
        return arr;
    }

    @Override
    public String toString() {
        return "Insertion Sort";
    }
}
