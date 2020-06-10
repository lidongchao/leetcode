package productOfArrayExceptSelf238;

/**
 * 思路：前缀法 + 后缀法
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :48.3 MB, 在所有 Java 提交中击败了11.76%的用户
 */
class Solution1 {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *  
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *  
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数数组
     * @return 处理后的数组
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 0) return new int[]{0};

        int len = nums.length;

        // 计算前缀乘积并保存
        int[] mulArr = new int[len];

        int mulLeft = 1;
        for (int i = 0; i < len; i++) {
            mulArr[i] = (mulLeft*=nums[i]);
        }

        // 一边计算后缀乘积，一边计算结果
        int[] ans = new int[len];

        int mulRight = 1;
        ans[len-1] = mulArr[len-2];
        for (int i = len-2; i > 0; i--) {
            ans[i] = mulArr[i-1] * (mulRight *= nums[i+1]);
        }
        ans[0] = mulRight * nums[1];

        return ans;
    }
}