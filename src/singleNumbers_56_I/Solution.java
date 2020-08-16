package singleNumbers_56_I;

/**
 * 思路：异或/位运算
 * a ^ a = 0
 * x ^ a ^ a ^ b ^ b ^ y   =   x ^ y
 * 找到 32 位中的某一位在 x a 是 1，在 y b 是 0，就能够将数组分成两部分
 * x ^ a ^ a = x
 * y ^ b ^ b = y
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了95.47%的用户
 * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整形数组
     * @return 两个只出现一次的数字
     */
    public int[] singleNumbers(int[] nums) {

        // 假设两个只出现一次的数字为 x y
        // 最终 xor = x ^ y
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        // 假设 xor = 001100011000，其中任意位置上的二进制 1 都表示 x 和 y 在此位置上的二进制数相反，
        // 可以通过 xor & (~xor + 1) 得到最低位的 1，根据这个 1 区分 x 和 y。
        //   001100011000
        // & 110011101000
        // = 000000001000
        int firstOne = xor & (~xor + 1);

        // x 和 y 一个必然进入到 xor1 分支，另一个必然进入到 xor2 分支，剩余成对出现的数字同样会成对进入 xor1 或 xor2
        // 最终 xor1 和 xor2 就是 x 和 y
        // 进一步优化，只需要计算 xor1，因为 xor1 ^ xor2 = xor，xor2 = xor ^ xor1
        int xor1 = 0;
//        int xor2 = 0;
        for (int n : nums) {
            if ((n & firstOne) == 0) {
                xor1 ^= n;
            }
//            else {
//                xor2 ^= n;
//            }
        }
        return new int[]{xor1, xor ^ xor1};
    }
}
