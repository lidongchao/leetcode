package longestPalindrome409;

/**
 * 思路 1：int[58=(122-65+1)] 数组记录字符出现的次数，A-Z 的 ASCII 码为 65-90，a-z 的 ASCII 码为 97-122，中间多出 6 个特殊字符，
 * 比写入 int[26*2] 要少一次大小写判断及偏移量修正。
 *
 * 如果需要这样一个逻辑：对一个整数，如果是偶数则返回偶数，如果是奇数则返回其减一后的偶数，那么可以通过 num - (num & 1) 实现。
 *
 * 扩展：
 * num & 1 判断是否为奇数
 * num >> 1 除以 2
 * num << 1 乘以 2
 *
 * 我的实现
 * 执行用时 :2 ms, 在所有 Java 提交中击败了76.48%的用户
 * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了5.25%的用户
 *
 * 大佬的实现
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了5.25%的用户
 */
class Solution1 {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindrome/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 组成回文串的字母集合
     * @return 最长回文串的长度
     */
    public int longestPalindrome(String s) {
        // 统计每个字符的次数
        int[] dict = new int[58];
        for (char c : s.toCharArray()) {
            dict[c - 'A']++;
        }

//        // 我的写法：次数出现奇数，可以放在回文串的中间，长度加一；其次，计数成对出现的次数，再通过成对次数的两倍还原为字符串长度
//        int ans = 0;
//        int single = 0;
//        for (int wc : dict) {
//            if (single == 0 && wc % 2 == 1) {
//                single = 1;
//            }
//            ans += (wc >> 1) * 2;
//        }
//        return ans + single;

        // 大佬的写法：得到每个字符的次数 (奇数次则减一)，最后判断回文串的长度是否等于字母集合的长度，不等则说明有单个的字符，可以放在回文串的中间
        int ans = 0;
        for (int wc : dict) {
            ans += wc - (wc & 1);
        }
        return ans == s.length()? ans : ans + 1;
    }
}
