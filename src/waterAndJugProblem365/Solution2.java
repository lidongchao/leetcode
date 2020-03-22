package waterAndJugProblem365;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 思路 2：在思路 1 的基础上进行优化：
 * 假设 x > y，任意时刻，A B 两个水壶都只有可能有如下几种状态：
 *   -- 确定状态
 *   1. (0, 0) A 空 B 空，总量为 0，不操作无法跳转，操作能够 +x 或 +y，跳转至 2 或 3
 *   2. (x, 0) A 满 B 空，总量为 x，不操作能够跳转至 5，操作能够 +y 或 -x，跳转至 4 或 0
 *   3. (0, y) A 空 B 满，总量为 y，不操作能够跳转至 6，操作能够 +x 或 -y，跳转至 4 或 0
 *   4. (x, y) A 满 B 满，总量为 x+y，不操作无法跳转，操作能够 -x 或 -y，跳转至 3 或 2
 *   -- 不确定状态集合：a 和 b 有多种可能
 *   5. (a, y) A 部分 B 满，总量为 a+y，不操作能够跳转至 7，操作能够 -a 或 +(x-a) 或 -y，跳转至 3 或 4 或 6
 *   6. (a, 0) A 部分 B 空，总量为 a，不操作能够跳转至 5 或 8，操作能够 -a 或 +(x-a) 或 +y，跳转至 1 或 2 或 5
 *   7. (x, b) A 满 B 部分，总量为 x+b，不操作能够跳转至 5，操作能够 -x 或 -b 或 +(y-b)，跳转至 8 或 2 或 4
 *   8. (0, b) A 空 B 部分，总量为 b，不操作能够跳转至 6，操作能够 +x 或 -b 或 +(y-b)，跳转至 7 或 1 或 3
 *   -- 无法到达状态
 *   8. (a, b) A 部分 B 部分
 *
 * 给出 A B 两个水壶的总量，由于不存在 A 部分 B 部分 这种状态，所以能够推断出两个水壶的状态，即使状态不唯一，也可以相互转化。
 *
 * 例如，x=3 y=5，如果两个水壶的总量为 7，那么可以得知各自的水量只能为 (2, 5) 或 (3, 4)，且这两个状态可以互相转化。
 *
 * 因此，可以只用两个水壶的总量作为状态，进行优化。
 *
 * 然后分析在不同的总量可以跳转的状态以及进行的操作，总共有 +x +y -x -y -a -b +(x-a) +(y-b) 八种操作，
 * 但 -a -b +(x-a) +(y-b) 只能回到确定状态，没有意义，因此可以接受的操作只剩下 +x +y -x -y 四种。
 *
 * 执行用时 :75 ms, 在所有 Java 提交中击败了13.76%的用户
 * 内存消耗 :55.3 MB, 在所有 Java 提交中击败了7.35%的用户
 */
class Solution2 {
    /**
     * 有两个容量分别为 x 升和 y 升的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z 升的水？
     *
     * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z 升水。
     *
     * 你允许：
     *   + 装满任意一个水壶
     *   + 清空任意一个水壶
     *   + 从一个水壶向另外一个水壶倒水，直到装满或者倒空
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x 第一个水壶 A 的容量
     * @param y 第二个水壶 B 的容量
     * @param z 想要得到的水的体积
     * @return 是否能够得到
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || x + y < z) return false;
        if (0 == z) return true;

        // Set 存储已经经过的状态
        Set<Integer> markState = new HashSet<>();

        // Queue 存储新生成但还没有执行下一步操作的状态
        Queue<Integer> runningState = new ArrayDeque<>();
        // 初始状态为 (0)
        runningState.add(0);
        markState.add(0);

        // 当 Queue 为空表示所有状态都已到达，但没有满足条件的状态
        int state;
        int full = x+y;
        while (!runningState.isEmpty()) {
            // 取出一个状态，进行 4 种状态变换
            state = runningState.remove();
            // +x
            if ( state + x <= full && markState.add(state + x)) {
                runningState.add(state + x);
            }
            // +y
            if ( state + y <= full && markState.add(state + y)) {
                runningState.add(state + y);
            }
            // -x
            if ( state - x >= 0 && markState.add(state - x)) {
                runningState.add(state - x);
            }
            // -y
            if ( state - y >= 0 && markState.add(state - y)) {
                runningState.add(state - y);
            }
            if (markState.contains(z)) {
                return true;
            }

        }
        return false;
    }
}
