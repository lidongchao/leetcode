package countTheRepetitions466;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：寻找循环结
 *
 * 没有想出来，抄答案
 */
class Solution {
    /**
     * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
     * <p>
     * 另一方面，如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
     * 例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
     * <p>
     * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。
     * <p>
     * 现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
     * <p>
     * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-the-repetitions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s1 字符串 1
     * @param n1 字符串 1 的重复次数
     * @param s2 字符串 2
     * @param n2 字符串 2 的重复次数
     * @return 满足使 [[s2,n2],M] 从 [S1,n1] 获得的最大整数 M
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();

        // 状态
        int count1 = 0;  // 已经遍历多少次 s1
        int count2 = 0;  // 已经遍历多少次 s2
        int p = 0;  // 当前在 s2 的位置

        Map<Integer, int[]> mp = new HashMap<>();  // 记录每一次 s1 遍历结束后当前的状态，寻找循环

        while (count1 < n1) {
            // 遍历一次 s1
            for (int i = 0; i < len1; i++) {
                // 尝试匹配 s1 和 s2
                if (chars1[i] == chars2[p]) {
                    p++;
                    // s2 完成一次遍历，从头开始循环，计数加一
                    if (p == len2) {
                        p = 0;
                        count2++;
                    }
                }
            }
            count1++;

            // s1 完成一次遍历，记录当前状态：p count1 count2
            if (!mp.containsKey(p)) {
                mp.put(p, new int[]{count1, count2});

            }
            // 出现了循环，这次结束后状态 p 以前出现过
            else {
                // 将上一次的状态 p 以及对应的 count1 和 count2 取出来，和这次的状态做比较，
                // 就能知道一次循环需要 circle1 个 s1 和 circle2 个 s2
                int[] last = mp.get(p);
                int circle1 = count1 - last[0];
                int circle2 = count2 - last[1];
                // 当前已经遍历了 count1 个 s1，还剩 n1-count1 个，还能够循环 (n1-count1)/circle1 次 (无法除尽的情况就向下取整)，
                // 然后跳过循环，直接加在 count1 和 count2 上，最后的 while 循环用于暴力解决无法除尽的情况。
                count2 += circle2 * ((n1 - count1) / circle1);
                count1 += circle1 * ((n1 - count1) / circle1);
            }
        }
        return count2 / n2;
    }
}
