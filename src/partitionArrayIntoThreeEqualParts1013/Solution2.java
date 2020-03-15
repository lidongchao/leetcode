package partitionArrayIntoThreeEqualParts1013;

/**
 * 思路 2：数组能被三等分，必然有其数学规律，即每一份的和都是数组总和的 1/3，根据这一规律可以很快找到解或判断出无解
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :44.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution2 {
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
        int part1 = 0, part2 = 0;
        // 先对数组求和
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        // 无法被 3 整除，必然无法分成三等份
        if (sum % 3 != 0) return false;
        // 能被三等分，可以求出每一份的和
        int sum_part = sum / 3;
        // 移动指针，先找第一等份，再找第二等份，都能找到就返回 true，否则返回 false
        for (int i = 0; i <= A.length-3; i++) {
            part1 += A[i];
            // 寻找 part1
            if (part1 != sum_part) continue;
            // 找到 part1，寻找 part2
            for (int j = i+1; j <= A.length-2; j++) {
                part2 += A[j];
                if (part2 == sum_part) return true;
            }
            // 找到 part1，没有找到 part2，没有必要再找下一个 part1
            return false;
        }
        // 没有找到 part1 和 part2
        return false;
    }
}
