package findTheDuplicateNumber287;

/**
 * 思路 1：Floyd Cycle Detection Algorithm 、Floyd 判圈算法
 *
 * 假设数组长度为 5，包含数字 1-4，具体内容为 [1(0) 3(1) 4(2) 2(3) 2(4)]，括号内为索引值。
 *
 * 我们根据数组内容构造一个有向图，每个索引值 i 代表一个点，i 到 nums[i] 代表一条边，则图可以表示为
 *
 * 0 -> 1 -> 3 -> 2 -> 4
 *                ^    |
 *                |    |
 *                 ----
 *
 * 一般的，符合题目要求的数组构造出的有向图，都是有向有环图，且从点 0 出发，一定能访问到这个环。
 *
 * 首先，图包含 n+1 个点，n+1 条边，点 0 作为起始点，只能指向其他任意一点，且不会有其他点指向它，所以可以从图中摘掉。
 * 剩余 n 个点，n 条边，每个点都有且只有一个出度，但至少有一个点拥有两个或以上的入度，所以必然出现环。(证明略)
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了6.67%的用户
 */
class Solution {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设只有一个重复的整数，找出这个重复的数。
     *
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数数组
     * @return 重复的数字
     */
    public int findDuplicate(int[] nums) {
        // 第一步，快慢指针同时从原点出发，直到快慢指针相遇
        int quick = 0;
        int slow = 0;

        do {
            slow = nums[slow];
            quick = nums[nums[quick]];
        } while (quick != slow);

        // 第二步，两个慢指针，一个从原点出发，另一个从相遇点出发，直到再次相遇
        int p1 = 0;
        int p2 = quick;

        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        // 第二次相遇点就是环的入口
        return p1;
    }
}
