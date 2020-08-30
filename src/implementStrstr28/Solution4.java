package implementStrstr28;

import java.util.Arrays;

/**
 * 思路 4：KMP 算法
 *
 * KMP 算法是根据三位作者 (D.E.Knuth, J.H.Morris, V.R.Pratt) 的名字来命名的，算法的全称是 Knuth Morris Pratt 算法，简称为 KMP。
 *
 * KMP 算法的核心思想和 BM 算法非常相近，但是由倒序匹配变为了正序匹配。在模式串与主串匹配的过程中，当遇到不可匹配的字符的时候，我们希望
 * 找到一些规律，可以将模式串往后多滑动几位，跳过那些肯定不会匹配的情况。我们把不能匹配的那个字符仍然叫做坏字符，把已经匹配的那段字符串叫
 * 做好前缀。
 *
 * 当遇到坏字符的时候，我们就要把模式串往后滑动，在滑动的过程中，只要模式串和好前缀有上下重合，前面几个字符的比较，就相当于拿好前缀的后缀
 * 子串，跟模式串的前缀子串在比较。因此我们只需要拿好前缀本身，在它的后缀子串中，查找最长的那个可以跟好前缀的前缀子串匹配的。假设我们正在
 * 比较主串于索引 i 的字符和模式串于索引 j 的字符时遇到了坏字符，那么好前缀的长度是 j，同时假如最长的可匹配的那部分前缀子串是 {v}，长度
 * 是 k。我们把模式串一次性往后滑动 j-k 位，相当于每次遇到坏字符的时候，我们就把 j 更新为 k，i 不变，然后继续比较。
 *
 *
 *
 * -- 极客时间《数据结构与算法之美》 34 | 字符串匹配基础（下）：如何借助BM算法轻松理解KMP算法？
 *
 * 执行用时：7 ms, 在所有 Java 提交中击败了13.07%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了8.33%的用户
 */
public class Solution4 {
    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     *
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param haystack 主串
     * @param needle 模式串
     * @return 模式串在主串中的起始索引
     */
    public int strStr(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        int[] next = getNext(needle);

        int i = 0, j = 0;
        for (; i < n; i++) {
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            if (j == m) {  // 找到
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(String s) {
        int m = s.length();

        /* next 数组，next[i] = k 表示 s[0 .. i] 子串的最长可匹配前缀子串是 s[0 .. k]，最长可匹配后缀子串是 s[i-k .. i]
         * 且 s[0 .. k] = s[i-k .. i]，其长度为 k+1。next[i] = -1 表示没有最长可匹配前缀/后缀子串。
         */
        int[] next = new int[m];
        next[0] = -1;

        int k = -1;  // 关键角色

        for (int i = 1; i < m; i++) {
            // 刚进入 for 循环时，k = next[i - 1]，如果 k 不等于 -1，说明 s[0 .. i-1] 的最长可匹配前缀子串为 s[0 .. k]，
            // 接着比较 s[k+1] 是否等于 s[i]，如果相等，跳出 while 循环，s[0 .. i] 的最长可匹配前缀子串就是 s[0 .. k+1]
            while (k != -1 && s.charAt(k + 1) != s.charAt(i)) {
                k = next[k];  // 如果不等，则退而求其次，得到的 k 表示 s[0 .. i-1] 的非最长可匹配前缀子串
            }
            // 从 while 出来后，要么 k = -1，表示从头开始匹配，要么 匹配上，k++
            if (s.charAt(k + 1) == s.charAt(i)) {
                k++;
            }
            // 填写 next 数组
            next[i] = k;
        }
        return next;
    }
}
