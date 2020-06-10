package largestRectangleInHistogram84;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 思路 1：BF 暴力
 *
 * 执行用时 :394 ms, 在所有 Java 提交中击败了39.44%的用户
 * 内存消耗 :47.4 MB, 在所有 Java 提交中击败了6.52%的用户
 */
class Solution1 {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights 柱子高度组成的数组
     * @return 矩形的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        largest = 0;
        largestRectangleArea(heights, 0, heights.length);
        return largest;
    }

    private void largestRectangleArea(int[] arr, int left, int right) {
        if (debug) {
            System.out.println(String.format("arr: %s: left: %d, right: %d", Arrays.toString(arr), left, right));
        }
        if (left >= right) {
            return;
        }

        if (right - left == 1) {
            if (arr[left] > largest) {
                if (debug) {
                    System.out.println(String.format("old: %s, new: %s, left: %d, right: %d", largest, arr[left], left, right));
                }
                largest = arr[left];
            }
            return;
        }

        int[] minIndexes = getMinIndex(arr, left, right);
        assert minIndexes != null;
        if (debug) {
            System.out.println(String.format("minIndexes: %s", Arrays.toString(minIndexes)));
        }

        int area = (right - left) * arr[minIndexes[0]];

        if (area > largest) {
            if (debug) {
                System.out.println(String.format("old: %s, new: %s, left: %d, right: %d", largest, area, left, right));
            }
            largest = area;
        }

        largestRectangleArea(arr, left, minIndexes[0]);
        largestRectangleArea(arr, minIndexes[minIndexes.length-1]+1, right);
        for (int i = 0; i < minIndexes.length - 1; i++) {
            largestRectangleArea(arr, minIndexes[i]+1, minIndexes[i+1]);
        }

    }

    private int[] getMinIndex(int[] arr, int left, int right) {
        int min = arr[left];
        LinkedList<Integer> minIndexList = new LinkedList<>();
        minIndexList.add(left);
        for (int i = left+1; i < right; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndexList = new LinkedList<>();
                minIndexList.add(i);
            } else if (arr[i] == min) {
                minIndexList.add(i);
            } else {
                // do nothing
            }
        }
        return minIndexList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public Solution1() {
    }

    public Solution1(boolean debug) {
        this.debug = debug;
    }

    private int largest = 0;
    private boolean debug = false;

}
