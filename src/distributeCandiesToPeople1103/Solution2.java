package distributeCandiesToPeople1103;

/**
 * 思路 2：n 个小朋友，如果糖果足够多，第 1 轮消耗糖果数 (1+n)*n/2+n*0，第 2 轮消耗 (1+n)*n/2+n*n*1，
 * 第 m 轮消耗 (1+n)*n/2+n*n*(m-1)，先判断能完整地给多少轮，再把剩下的依次给每个小朋友
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了5.27%的用户
 */
class Solution2 {
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
        // 计算 (1+n)*n/2
        int completedRoundOfCandies = (1 + num_people) * num_people >> 1;

        int round = 0;
        int distribution;

        // 计算 m
        while (candies >= (distribution = completedRoundOfCandies + round * num_people * num_people)) {
            round++;
            candies -= distribution;
        }

        // 如果 m 非零，则表示可以完整地分 m 轮
        if (round > 0) {
            for (int i = 0; i < num_people; i++) {
                // 第 1 轮能分 (i+1)+0n，第 2 轮能分 (i+1)+1n，第 m 轮能分 (i+1)+(m-1)n
                // 总共能分 (i+1)m + n*m(m-1)/2 = (2+2i+mn-n)*m/2
                plan[i] = (2+2*i+round*num_people-num_people)*round>>1;
            }
        }

        // 剩余的糖果按顺序分，每个小朋友能分得的糖果数为 m*n+(i+1)，i 从 0 开始，为小朋友的顺序号
        int base = round * num_people;
        int step = 0;
        while (candies >= (distribution = base + ++step)) {
            plan[step-1] += distribution;
            candies -= distribution;
        }
        if (candies > 0) {
            plan[step-1] += candies;
        }

        return plan;
    }
}
