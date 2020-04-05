package allSortAlgorithm;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        // 冒泡排序
        SortAlgorithm bubble = new BubbleSort();
        // 插入排序
        SortAlgorithm insert = new InsertionSort();
        // 选择排序
        SortAlgorithm select = new SelectionSort();
        // 快速排序
        SortAlgorithm quick = new QuickSort();
        // 归并排序
        SortAlgorithm merge = new MergeSort();

        sortTest(bubble);
        sortTest(insert);
        sortTest(select);
        sortTest(quick);
        sortTest(merge);
    }

    static void sortTest(SortAlgorithm algorithm) {
        System.out.println("Algorithm test: " + algorithm);

        int[] arr_1 = {4,2,6,3,5,1};
        int[] expect_1 = {1,2,3,4,5,6};
        AssertUtils.assertEqualsIntArray(expect_1, algorithm.sort(arr_1));

        int[] arr_2 = {1,2,3,4,5,6};
        int[] expect_2 = {1,2,3,4,5,6};
        AssertUtils.assertEqualsIntArray(expect_2, algorithm.sort(arr_2));

        int[] arr_3 = {6,5,4,3,2,1};
        int[] expect_3 = {1,2,3,4,5,6};
        AssertUtils.assertEqualsIntArray(expect_3, algorithm.sort(arr_3));

        int[] arr_4 = {0};
        int[] expect_4 = {0};
        AssertUtils.assertEqualsIntArray(expect_4, algorithm.sort(arr_4));
    }
}
