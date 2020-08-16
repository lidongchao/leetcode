package addStrings415;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 思路：模拟
 *
 * 执行用时：6 ms, 在所有 Java 提交中击败了15.60%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了8.82%的用户
 */
class Solution {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 提示：
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return 和字符串
     */
    public String addStrings(String num1, String num2) {
        Deque<Integer> stack = new ArrayDeque<>();

        int floating = 0;

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        while (index1 >= 0 && index2 >= 0) {
            int sum = numberOf(num1, index1) + numberOf(num2, index2) + floating;
            floating = addStack(stack, sum);
            index1--;
            index2--;
        }

        while (index1 >= 0) {
            int sum = numberOf(num1, index1) + floating;
            floating = addStack(stack, sum);
            index1--;
        }

        while (index2 >= 0) {
            int sum = numberOf(num2, index2) + floating;
            floating = addStack(stack, sum);
            index2--;
        }

        if (stack.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if (floating != 0) {
            sb.append(floating);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }

        return sb.toString();
    }

    private static int addStack(Deque<Integer> stack, int num) {
        if (num >= 10) {
            stack.push(num - 10);
            return num / 10;
        } else {
            stack.push(num);
            return 0;
        }
    }

    private static int numberOf(String s, int index) {
        return s.charAt(index) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "45678"));
    }
}
