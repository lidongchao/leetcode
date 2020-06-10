package translateNumLcof_46;

import java.util.*;

/**
 * 思路 1：模拟、递归
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了22.29%的用户
 * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *  
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi" (1,2,3,5,8), "bwfi" (1,22,5,8), "bczi" (1,2,25,8), "mcfi" (12,2,5,8)
     * 和"mzi" (12,25,8)
     *  
     * 提示：
     * 0 <= num < 2^31
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num 待翻译的数字
     * @return 多少种翻译方法
     */
    public int translateNum(int num) {
        ArrayList<Integer> nums = new ArrayList<>();
        ans = 0;

        // 将数字 num 拆成每个元素都是 0-9 的数组
        while (num > 0) {
            nums.add(num % 10);
            num /= 10;
        }
        Collections.reverse(nums);

        // 尝试转换 nums
        /*StringBuilder sb = new StringBuilder();*/
        // 考虑将 nums[0] 转换为字符
        translateNum(nums, 0, 1/*, sb*/);
        // 考虑将 nums[0..1] 转换为字符
        translateNum(nums, 0, 2/*, sb*/);

        return ans;
    }

    private void translateNum(ArrayList<Integer> nums, int current, int len/*, StringBuilder sb*/) {
        // 终止条件 1
        if (current >= nums.size() && len == 1) {
            // 这里统计了，终止条件 2 就不用重复统计了
            ans++;
            return;
        }
        // 终止条件 2
        if (current >= nums.size()-1 && len == 2) {
            return;
        }

        // 将 nums[current] 转换为字符
        if (len == 1) {
            // 必定能够转换
            /*Character c = intToChar(nums.get(current));*/
            // 添加到 sb 中
            /*sb.append(c);*/
            // 下一步转换，分别尝试 1 个数字和 2 个数字
            translateNum(nums, current+1, 1/*, sb*/);
            // 理论上这里应该有以下两步操作，但是实际上效果抵消，无需再执行
            // sb.deleteCharAt(sb.length()-1);
            // sb.append(c);
            translateNum(nums, current+1, 2/*, sb*/);
            // 尝试结束，恢复现场
            /*sb.deleteCharAt(sb.length()-1);*/
        } else {  // 将 nums[current..current+1] 转换为字符
            // 506 只能翻译为 fag，06 不能转换为 g，直接返回
            if (nums.get(current) == 0) return;
            // 转换两个数字，可能会失败，失败则返回 null
            /*Character c = intToChar(nums.get(current) * 10 + nums.get(current+1));*/
            if (canConvert(nums.get(current) * 10 + nums.get(current+1))/*c != null*/) {
                /*sb.append(c);*/
                translateNum(nums, current+2, 1/*, sb*/);
                translateNum(nums, current+2, 2/*, sb*/);
                /*sb.deleteCharAt(sb.length()-1);*/
            }
        }
    }

    private boolean canConvert(int i) {
        return (i >= 10 && i <= 25);
    }
    /*
    private Character intToChar(int i) {
        if (i < 0 || i > 25) return null;
        return (char) ('a' + i);
    }
    */

    private int ans;
}
