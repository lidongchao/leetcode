package lastRemainingNumOfCircle_62;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 思路 1：模拟删除数据的过程 TLE
 *
 * 使用一个队列存储所有数字，然后如果需要删除第 3 个数字，则将前 2 个数字移动到队列末尾，再删除队列头部的数字。
 * 循环直至队列只剩下一个数字。
 *
 * 0 1 2 3 4
 * [2] 3 4 0 1
 * [0] 1 3 4
 * [4] 1 3
 * [1] 3
 *
 */
class Solution1 {
    /**
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里剩下的最后一个数字。
     *
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
     * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     * 限制：
     * 1 <= n <= 10^5
     * 1 <= m <= 10^6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 数字的个数
     * @param m 每次删除第几个数字
     * @return 最后剩下的数字
     */
    public int lastRemaining(int n, int m) {
        // 初始化队列为所有数字
        Queue<Integer> circle = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        // 模拟删除数字的过程
        while (circle.size()  > 1) {
            // 前 m-1 个数字移动到队列末尾
            for (int i = 0; i < m-1; i++) {
                circle.add(circle.poll());
            }
            // 删除第 m 个数字
            circle.poll();
        }
        return circle.poll();
    }
}
