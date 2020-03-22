package waterAndJugProblem365;

/**
 * 思路 3：最大公约数
 *
 * 根据思路 2 可以得知，两个水壶的总量只有 +x -x +y -y 四种操作是有意义的，因此只需要找到让 ax + by = z 成立的 a 和 b
 *
 * 根据裴蜀定理，ax + by = z 有解当且仅当 z 是 gcd(x, y) 的倍数。
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了10.29%的用户
 *
 */
class Solution3 {
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
        if (0 == x || 0 == y) {
            return 0 == z || x + y == z;
        }

        int m;
        while ( (m = x % y) != 0) {
            x = y;
            y = m;
        }
        return z % y == 0;
    }
}
