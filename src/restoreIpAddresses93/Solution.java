package restoreIpAddresses93;

import java.util.LinkedList;
import java.util.List;

/**
 * 思路：回溯
 *
 * 执行用时：11 ms, 在所有 Java 提交中击败了11.85%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了50.70%的用户
 */
class Solution {
    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     * 示例:
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 包含 ip 的字符串
     * @return ip
     */
    public List<String> restoreIpAddresses(String s) {
        // 最短 4 个数字，最长 12 个数字
        List<String> ipList = new LinkedList<>();
        int[] dotIndex = new int[3];
        restore(s, 0, 0, dotIndex, ipList);
        return ipList;
    }

    private static void restore(String s, int ipNum, int curIndex, int[] dotIndex, List<String> ipList) {
        // 确定了前面三段，如果第四段是有效整数，则记录下来
        if (ipNum >= 3) {
            if (curIndex < s.length() && isValidIpContent(s.substring(curIndex))) {
                ipList.add(generate(s, dotIndex));
            }
            return;
        }
        // 超过字符串长度，不再继续
        if (curIndex >= s.length()) {
            return;
        }
        // 当前段的长度是一位
        if (isValidLength(s.length() - curIndex - 1, 3 - ipNum)) {
            dotIndex[ipNum] = curIndex;
            restore(s, ipNum + 1, curIndex + 1, dotIndex, ipList);
        }
        // 当前数字是 0，不允许出现 01 001 这样的数字
        if (s.charAt(curIndex) == '0') {
            return;
        }
        // 当前段的长度是两位
        if (isValidLength(s.length() - curIndex - 2, 3 - ipNum) &&
                curIndex < s.length() - 1 &&
                isValidIpContent(s.substring(curIndex, curIndex + 2))) {
            dotIndex[ipNum] = curIndex + 1;
            restore(s, ipNum + 1, curIndex + 2, dotIndex, ipList);
        }
        // 当前段的长度是三位
        if (isValidLength(s.length() - curIndex - 3, 3 - ipNum) &&
                curIndex < s.length() - 2 &&
                isValidIpContent(s.substring(curIndex, curIndex + 3))) {
            dotIndex[ipNum] = curIndex + 2;
            restore(s, ipNum + 1, curIndex + 3, dotIndex, ipList);
        }
    }

    /**
     * 判断长度 len 是否足够分为 num 段
     * @param len 长度
     * @param num 段数
     * @return 是否足够
     */
    private static boolean isValidLength(int len, int num) {
        return len <= 3 * num && len >= num;
    }

    /**
     * 判断 ip 段是否有效
     * @param s ip 段
     * @return 是否有效
     */
    private static boolean isValidIpContent(String s) {
        if (s.length() >3 ||
                (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    /**
     * 将 s 根据三个点的索引转换为 ip 地址格式
     * @param s 不包含点的 ip 地址
     * @param dotIndex 三个点的前一位数字的索引
     * @return 转换后的 ip 地址
     */
    private static String generate(String s, int[] dotIndex) {
        return s.substring(0, dotIndex[0] + 1) +
                "." +
                s.substring(dotIndex[0] + 1, dotIndex[1] + 1) +
                "." +
                s.substring(dotIndex[1] + 1, dotIndex[2] + 1) +
                "." +
                s.substring(dotIndex[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(generate("25525511135", new int[]{2,5,8}));  // 255.255.111.35
        System.out.println(generate("25525511135", new int[]{2,5,7}));  // 255.255.11.135
    }
}