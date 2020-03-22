package waterAndJugProblem365;

import java.util.*;

/**
 * 思路 1：模拟以下操作，使用动态规划法求解 (更像是 BFS 深度优先遍历算法)
 * 操作 1：装满 A
 * 操作 2：装满 B
 * 操作 3：倒空 A
 * 操作 4：倒空 B
 * 操作 5：A 倒入 B，直到 A 倒空或者 B 装满
 * 操作 6：B 倒入 A，直到 B 倒空或者 A 装满
 *
 * 初始状态为 (0, 0)，经过上述 6 种操作，可以分别到达两种有效状态 (另外 4 种无效)，然后再从这两种状态出发，经过同样的操作，到达更多的状态，
 * 直到某一种状态满足条件，或所有状态都无法满足。
 *
 * 为了不重复到达同一状态，可以用一个 Set 存储已经到达过的状态。再使用一个 Queue 存储新的状态。
 *
 * 执行用时 :871 ms, 在所有 Java 提交中击败了5.04%的用户
 * 内存消耗 :90.8 MB, 在所有 Java 提交中击败了5.88%的用户
 */
class Solution1 {
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
        if (0 == z) return true;

        // Set 存储已经经过的状态
        Set<Integer> markState = new HashSet<>();

        col = y+1;

        // Queue 存储新生成但还没有执行下一步操作的状态
        Queue<Integer> runningState = new ArrayDeque<>();
        // 初始状态为 (0, 0)
        runningState.add(0);
        markState.add(0);

        // 当 Queue 为空表示所有状态都已到达，但没有满足条件的状态
        int state, a, b;
        while (!runningState.isEmpty()) {
            // 取出一个状态，进行 6 种状态变换
            state = runningState.remove();
            a = getAbyKey(state);
            b = getBbyKey(state);
            // 装满 A
            if (a != x && markState.add(generateKey(x, b))) {
                if (x + b == z) return true;
                runningState.add(generateKey(x, b));
            }
            // 装满 B
            if (b != y && markState.add(generateKey(a, y))) {
                if (a + y == z) return true;
                runningState.add(generateKey(a, y));
            }
            // 倒空 A
            if (a != 0 && markState.add(generateKey(0, b))) {
                if (b == z) return true;
                runningState.add(generateKey(0, b));
            }
            // 倒空 B
            if (b != 0 && markState.add(generateKey(a, 0))) {
                if (a == z) return true;
                runningState.add(generateKey(a, 0));
            }
            // A 倒入 B，直到 A 倒空或者 B 装满
            if (b != y) {
                int pour = Math.min(a, y-b);
                if (markState.add(generateKey(a-pour, b+pour))) {
                    runningState.add(generateKey(a-pour, b+pour));
                }
            }
            // B 倒入 A，直到 B 倒空或者 A 装满
            if (a != x) {
                int pour = Math.min(b, x-a);
                if (markState.add(generateKey(a+pour, b-pour))) {
                    runningState.add(generateKey(a+pour, b-pour));
                }
            }

        }
        return false;
    }

    private static int generateKey(int x, int y) {
        return x * col + y;
    }

    private static int getAbyKey(int key) {
        return key / col;
    }

    private static int getBbyKey(int key) {
        return key % col;
    }

    private static int col;
}
