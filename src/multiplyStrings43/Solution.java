package multiplyStrings43;

/**
 * 思路：模拟
 *
 * 执行用时：3 ms, 在所有 Java 提交中击败了94.87%的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了90.07%的用户
 */
class Solution {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 乘积
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2 - 1;
        int[] res = new int[len];

        // 逐位相乘，暂时不考虑进位
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int c1 = num1.charAt(len1 - 1 - i) - '0';
                int c2 = num2.charAt(len2 - 1 - j) - '0';
                res[i + j] += c1 * c2;
            }
        }

        // 从低位开始处理进位
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int k = 0; k < len; k++) {
            int x = res[k] + carry;
            res[k] = x % 10;
            carry = x / 10;
            sb.append(res[k]);
        }
        // 再处理最后剩余的一点进位
        while (carry > 0) {
            sb.append(carry % 10);
            carry /= 10;
        }

        return sb.reverse().toString();
    }
}

