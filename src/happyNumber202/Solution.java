package happyNumber202;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：暴力求解，hashset 存储已经出现过的数字，用于检测无限循环
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了52.10%的用户
 * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了8.33%的用户
 */
class Solution {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
     * 也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 正整数
     * @return n 是否是快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (true) {
            n = happy(n);
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

    private int happy(int n) {
        int res = 0;

        while (n != 0) {
            int i = n % 10;
            res += i * i;
            n = n / 10;
        }
        return res;
    }
}
