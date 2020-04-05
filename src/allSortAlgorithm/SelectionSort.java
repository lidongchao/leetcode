package allSortAlgorithm;

import java.util.Arrays;

/**
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，
 * 将其放到已排序区间的末尾。
 *
 * -- 极客时间《数据结构与算法之美》 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？
 *
 * 时间复杂度：
 * 最好情况 O(n^2)
 * 最坏情况 O(n^2)
 * 平均情况 O(n^2)
 *
 * 空间复杂度：O(1) 属于原地排序算法
 *
 * 是否稳定：否
 *
 */
public class SelectionSort extends SortAlgorithm {

    /**
     * 选择排序，升序排序
     * @param a 待排序数组
     * @return 排序后的新数组
     */
    @Override
    public int[] sort(int[] a) {
        if (null == a) return null;

        int n = a.length;
        int[] arr = Arrays.copyOf(a, n);

        if (n <= 1) return arr;

        // 外层循环 n-1 次，第 n 次只有一个元素，不需要再比较
        for (int i = 0; i < n-1; i++) {
            // 内层循环 n-i 次，找到 [i, n-1] 的最小值，与 i 交换位置
            int idx = i;
            int min = arr[i];
            for (int j = i+1; j < n; j++) {
                if (arr[j] < min) {  // 寻找最小值及其下标
                    min = arr[j];
                    idx = j;
                }
            }
            arr[idx] = arr[i];  // 交换位置
            arr[i] = min;
        }

        return arr;
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }
}
