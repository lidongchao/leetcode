package RangeOfMovementLcof_13;

/**
 * 思路 1：暴力 + 剪枝
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     *
     * 提示
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m 地图长度
     * @param n 地图宽度
     * @param k 限制
     * @return 能够到达的格子数
     */
    public int movingCount(int m, int n, int k) {
        // 测试用，打印
//        HashMap<Integer, HashSet<Integer>> range = new HashMap<>();
        int move = 0;
        int max_j = n;
        for (int i = 0; i < m; i++) {
            int i_k = i / 10 + i % 10;
            if (i_k > k) {
                break;
            }
            for (int j = 0; j < max_j; j++) {
                if (j / 10 + j % 10 + i_k <= k) {
                    move++;
//                    HashSet<Integer> set = range.computeIfAbsent(i, x -> new HashSet<>());
//                    set.add(j);
                }
                else {
                    j = j - j % 10 + 9;
                    if ( i == 0 || ((j + 1 < n) && ((i-1) / 10 + (i-1) % 10 + (j+1) / 10 > k)) ) {
                        max_j = j;
                        break;
                    }
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (range.containsKey(i) && range.get(i).contains(j)) {
//                    System.out.print("X");
//                }
//                else {
//                    System.out.print("_");
//                }
//            }
//            System.out.println();
//        }

        return move;
    }
}
