package greatestCommonDivisorOfStrings1071;

/**
 * 思路 1：辗转相除法求最大公约数
 * 600 和 1515 的最大公约数：
 * 1515 / 600 = 2 ... 315
 * 600 / 315 = 1 ... 285
 * 315 / 285 = 1 ... 30
 * 285 / 30 = 9 ... 15
 * 30 / 15 = 2 ... 0
 * 最后一个除数 15 就是最大公约数
 *
 */
public class Solution1 {
    /**
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 两个字符串的最大公因子
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int len = gcd(str1.length(), str2.length());
        return str1.substring(0, len);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

}
