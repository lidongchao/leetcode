package countBinarySubstrings696;

/**
 * 思路：
 *
 * 执行用时：12 ms, 在所有 Java 提交中击败了78.36%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了97.04%的用户
 */
public class Solution {
    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     *
     * 重复出现的子串要计算它们出现的次数。
     *
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     *
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     * 注意：
     *
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 特定的重复子串次数
     */
    public int countBinarySubstrings(String s) {

        // 假设已经读过 000，那么紧接着的最多 3 个 1，都可以和前面组成有效子串
        char currentChar = 0;  // 当前访问的字符
        int prevCharNum = 0;  // 上一个不同字符的个数
        int currentCharNum = 0;  // 当前字符的个数
        int ans = -1;  // 当读到第一个字符时变为 0，开始正式计数

        for (Character c : s.toCharArray()) {
            if (c != currentChar) {  // 遇到不同字符
                prevCharNum = currentCharNum;  // 记录字符个数
                currentCharNum = 1;  // 重新计数
                currentChar = c;  // 更换当前字符
                ans++;
            } else {
                currentCharNum++;  //  当前字符加一
                if (prevCharNum >= currentCharNum) {  // 没有超过上一个字符的个数，可以组成有效子串
                    ans++;
                }
            }
        }
        return ans;
    }
}
