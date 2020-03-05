package distributeCandiesToPeople1103;

/**
 * 思路 1：按照题目要求的顺序给小朋友分糖果
 * step 1：第 1%num_people 个小朋友分 1 个糖果
 * step 2：第 2%num_people 个小朋友分 2 个糖果
 * ...
 * step n：第 n%num_people 个小朋友分 n 个糖果
 * step n+1：不够分了，都给第 (n+1)%num_people 个小朋友
 * 执行用时 :1 ms, 在所有 Java 提交中击败了90.51%的用户
 * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了5.27%的用户
 */
class Solution1 {
    /**
     * 排排坐，分糖果。
     *
     * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
     *
     * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
     *
     * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
     *
     * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下
     * 糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
     *
     * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/distribute-candies-to-people
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candies 糖果的数量
     * @param num_people 小朋友的数量
     * @return 每个小朋友能够分到的糖果数量的列表
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] plan = new int[num_people];
        int step = 0;
        // 判断本次分配的糖果够不够
        while ((candies -= (++step)) > 0) {
            // 够分，给！
            plan[(step-1)%num_people] += step;
        }
        // 最后一次有 (step+candies) 个糖果，不够应分配的数量，把所有的都给这位小朋友
        plan[(step-1)%num_people] += (candies+step);
        return plan;
    }
}
