package coinLcci_08_11;

/**
 * 思路 2：数学优化
 *
 */
class Solution2 {
    /**
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
     *
     * (结果可能会很大，你需要将结果模上1000000007)
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 总币值
     * @return 多少种表示方法
     */
    public int waysToChange(int n) {
        long ans = 0;

//        for (int i = 0; i <= n / 25; i++) {
//            int n_25 = n - i * 25;
//            for (int j = 0; j <= n_25 / 10; j++) {
//                int n_10 = n_25 - j * 10;
//                for (int k = 0; k <= n_10 / 5; k++) {
//                    ans++;
//                }
//            }
//        }

//        for (int i = 0; i <= n / 25; i++) {
//            int n_25 = n - i * 25;
//            for (int j = 0; j <= n_25 / 10; j++) {
//                int n_10 = n_25 - j * 10;
//                ans += n_10 / 5 + 1;
//            }
//        }

        for (int i = 0; i <= n / 25; i++) {
            int n_25 = n - i * 25;
            ans += (((n_25 / 5) + 1L) + ((n_25 % 10) / 5) + 1L) * (n_25 / 10 + 1L) / 2;
        }

        return (int) (ans % 1000000007);
    }
}
