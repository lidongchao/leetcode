package partitionArrayIntoThreeEqualParts1013;

/**
 * 思路 1：双指针 i j 暴力拆分数组，其中 [0, i] 为第一部分，[i+1, j] 为第二部分，[j+1, A.length-1] 为第三部分
 * 为了让每个部分都有数据，必须有 A.length >= 3 且 i < j < A.length-1
 *
 * 执行用时 :1769 ms, 在所有 Java 提交中击败了5.00%的用户
 * 内存消耗 :44.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
    /**
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A 整数数组
     * @return 是否能被三等分
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int part1 = 0, part2, part3;
        // 先对数组求和
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        // j <= A.length-2 i <= A.length-3
        // 先定一个 part1，再寻找有没有相同的 part2，最后再看 part3 是否也相同
        for (int i = 0; i <= A.length-3; i++) {
            part1 += A[i];
            part2 = 0;
            part3 = sum - part1;
            for (int j = i+1; j <= A.length-2; j++) {
                part2 += A[j];
                part3 -= A[j];
                if (part1 == part2 && part1 == part3) return true;
            }
        }
        return false;
    }
}
