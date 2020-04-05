package allSortAlgorithm;

import java.util.Arrays;

/**
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
 * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
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
public class BubbleSort extends SortAlgorithm {

    /**
     * 冒泡排序，升序排序
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
            // 提前退出冒泡循环的标志位
            boolean flag = true;
            // 内层每次从 0 开始，循环 n-1-i 次，次数随着外层循环轮数增加而减少，因为在数组末尾的 i 个数已经完成排序
            for (int j = 0; j < n-1-i; j++) {
                // 判断是否需要和右边的数进行交换
                // 相等时不会交换，是一个稳定的排序算法
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];  // 只需要常量级的临时空间，空间复杂度 O(1)，是一个原地排序算法
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;  // 表示有数据交换
                }
            }
            if (flag) break;  // 没有数据交换，提前退出
        }
        return arr;
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
