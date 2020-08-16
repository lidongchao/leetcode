package palindromeNumber9;

/**
 * 思路：反转
 *
 * 执行用时 :9 ms, 在所有 Java 提交中击败了99.06%的用户
 * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了5.14%的用户
 */
class Solution {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x 整数
     * @return 是否是回文数
     */
    public boolean isPalindrome(int x) {
        // 处理特殊情况
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;

        int palindrome = 0;

        // 当 x <= palindrome 时，x 已经将半数 (x 的位数是偶数) 或半数以上 (x 的位数是奇数) 的低位数字反转成 palindrome
        while (x > palindrome) {
            palindrome = x % 10 + 10 * palindrome;
            x = x  / 10;
        }

        return x == palindrome || x == palindrome / 10;
    }
}
