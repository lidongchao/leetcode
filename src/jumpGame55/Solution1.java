package jumpGame55;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 思路 1：逆向思维，从最后一个元素开始，先判断有哪些元素可以到达该元素，如果这些元素中包含第一个元素，则说明能够满足题目要求。
 * 否则，将这些可以到达最后一个元素的所有元素作为新的终点，继续判断有哪些元素可以到达该元素，
 * 循环此操作，直到找到第一个元素可以作为起点，或者所有与最后一个元素相关的元素都无法以第一个元素作为起点。
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * Queue:
 * 执行用时 :625 ms, 在所有 Java 提交中击败了11.49%的用户
 * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了20.31%的用户
 *
 * Array:
 * 执行用时 :296 ms, 在所有 Java 提交中击败了21.48%的用户
 * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了14.06%的用户
 */
class Solution1 {
    public boolean canJump(int[] nums) {
        // 存储所有可以到达最后一个元素，但还没有查找有哪些元素可以到达该元素的元素
//        Queue<Integer> queue = new ArrayDeque<>();
        int[] arr = new int[nums.length];
        // 标记哪些元素已经访问过
        boolean[] visited = new boolean[nums.length];

        // 初始化
//        queue.add(nums.length - 1);
        arr[0] = nums.length - 1;
        visited[nums.length - 1] = true;

        int p = 0;
        int q = 1;

//        while (!queue.isEmpty()) {
        while (p != q) {
//            int index = queue.poll();
            int index = arr[p++];

            // 找到第一个元素可以作为起点
            if (index == 0) return true;

            // 从队列中取出一个元素，判断有哪些元素可以到达该元素，如果存在且没有访问，加入队列中再标记为已访问
            for (int i = 0; i < index; i++) {
                if (index - i <= nums[i]) {
                    if (!visited[i]) {
//                        queue.add(i);
                        arr[q++] = i;
                        visited[i] = true;
                    }
                }
            }
        }
        // 所有与最后一个元素相关的元素都无法以第一个元素作为起点
        return false;
    }
}
