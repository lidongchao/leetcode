package implementStrstr28;

/**
 * 思路 1：BF 算法
 *
 * BF 算法中的 BF 是 Brute Force 的缩写，中文叫作暴力匹配算法，也叫朴素匹配算法，它是最简单、粗暴的字符串匹配算法。
 * 如果需要在字符串 A 中查找字符串 B，那字符串 A 就是主串，字符串 B 就是模式串。主串的长度记作 n，模式串的长度记作 m，显然 n >= m。
 * 主体思路是，我们在主串中，检查起始位置分别是 0、1、2…n-m 且长度为 m 的 n-m+1 个子串，看有没有跟模式串匹配的。
 * 最坏时间复杂度 O(n*m)
 *
 * 优点：
 * 1. 实际应用中，落入到最坏时间复杂度的情况极少，且大多数情况下，模式串和主串的长度都不会太长。
 * 2. 简单意味着容易实现，且不容易出错，工程首选。
 *
 * -- 极客时间《数据结构与算法之美》 32 | 字符串匹配基础（上）：如何借助哈希算法实现高效字符串匹配？
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了54.08%的用户
 * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了15.21%的用户
 */
public class Solution1 {
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
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        int i, j, k;

        // i + m - 1 < n，正好有 n-m+1 个子串，每个子串通过 k 搜索，每次模式串通过 j 搜索。
        for (i = 0; i < n-m+1; i++) {
            k = i;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(k++) != needle.charAt(j)) break;
            }
            // match
            if (j == m) return i;
        }
        // not match
        return -1;
    }
}
