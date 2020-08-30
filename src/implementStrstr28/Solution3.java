package implementStrstr28;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 3：BM 算法
 *
 * BM (Boyer-Moore) 算法是一种非常高效的字符串匹配算法。
 *
 * BM 算法的核心思想：
 * 我们把模式串和主串的匹配过程，看作模式串在主串中不停地往后滑动。当遇到不匹配的字符时，BF 算法和 RK 算法的做法是，模式串往后滑动一位，
 * 然后从模式串的第一个字符开始重新匹配。但是每次往后滑动一位显然并不是一个好的选择，因为这种做法忽视了主串和模式串之间的关系。BM 算法就
 * 能够在主串和模式串中寻找规律，借助这种规律，在模式串与主串匹配的过程中，当模式串和主串某个字符不匹配的时候，能够跳过一些肯定不会匹配的
 * 情况，将模式串往后多滑动几位。
 *
 * BM 算法包含两部分规则，分别是坏字符规则和好后缀规则。
 * 1. 坏字符规则
 * BM 算法的匹配顺序是按照模式串下标从大到小的顺序倒着匹配的。当发现某个字符没法匹配的时候，我们把这个没有匹配的字符叫做坏字符 (主串中的
 * 字符)。此时，我们把坏字符对应的模式串中的字符下标记作 si (此刻匹配到模式串的哪一个字符了)；如果坏字符在模式串中存在，我们把这个坏字符
 * 在模式串中最靠后的下标记作 xi (先让这个原本不匹配的字符匹配上)；如果不存在，我们把 xi 记作 -1。那模式串往后移动的位数就等于 si - xi。
 * 不过，单纯利用坏字符规则还是不够的。因为根据 si - xi 计算出来的移动位数，有可能是负数，比如主串是 aaaaaaaa，模式串是 baaa，si = 0，
 * xi = 3，si - xi = -3。
 *
 * 2. 好后缀规则
 * 同样还是倒着匹配。当发现某个字符没法匹配的时候，我们把已经匹配的字符串叫作好后缀 (主串中的字符串)，记作 {u}。我们拿它在模式串中查找，
 * 如果找到了另一个跟 {u} 相匹配的子串 {u*}，那我们就将模式串滑动到子串 {u*} 与主串中 {u} 对齐的位置。否则，我们还要考察好后缀的后缀子
 * 串，是否存在跟模式串的前缀子串匹配的。
 * 所谓某个字符串 s 的后缀子串，就是最后一个字符跟 s 对齐的子串，比如 abc 的后缀子串就包括 c 和 bc。所谓前缀子串，就是起始字符跟 s 对齐
 * 的子串，比如 abc 的前缀子串有 a 和 ab。我们从好后缀的后缀子串中，找一个最长的并且能跟模式串的前缀子串匹配的，假设是 {v}，然后将模式串
 * 滑动到与 {v} 对齐的位置。
 *
 * -- 极客时间《数据结构与算法之美》 33 | 字符串匹配基础（中）：如何实现文本编辑器中的查找功能？
 *
 * 执行用时：8 ms, 在所有 Java 提交中击败了11.05%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了16.71%的用户
 */
public class Solution3 {
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
        int n = haystack.length();  // 主串长度 n
        int m = needle.length();  // 模式串长度 m

        if (m == 0) return 0;

        // 坏字符查找表
        Map<Character, Integer> badCharIndex = new HashMap<>();
        generateBC(needle, badCharIndex);

        // 好后缀查找表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(needle, suffix, prefix);

        int i = 0;  // 记录当前模式串的起始位置在主串中的索引
        while (i <= n - m) {
            int j;  // 记录当前模式串中正在进行匹配的索引
            for (j = m - 1; j >= 0; j--) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;  // 出现坏字符
                }
            }
            if (j < 0) {
                return i;  // 没有出现坏字符，匹配成功
            }
            // 坏字符为 haystack[i+j]，对应模式串的字符为 needle[j]
            int moveByBC = 0;
            if (badCharIndex.containsKey(haystack.charAt(i + j))) {
                moveByBC = j - badCharIndex.get(haystack.charAt(i + j));
            } else {
                moveByBC = j - (-1);
            }
            // 好后缀为 needle[j+1 .. m-1]
            int moveByGS = 0;  // 如果不存在好后缀，则 moveByGS 不参与计算，moveByBC 一定为正数
            if (j < m - 1) {  // 存在好后缀
                moveByGS = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(moveByBC, moveByGS);
        }
        return -1;
    }

    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int gsLen = m - 1 - j;  // 好后缀长度
        if (suffix[gsLen] != -1) {  // 模式串中存在另一个和好后缀相匹配的子串
            return j + 1 - suffix[gsLen];
        } else {  // 否则，考察好后缀的后缀子串，是否存在跟模式串的前缀子串匹配的
            for (int k = gsLen; k > 0; k--) {
                if (prefix[k]) {
                    return m - k;
                }
            }
        }
        return m;
    }

    private void generateBC(String needle, Map<Character, Integer> badCharIndex) {
        for (int i = 0; i < needle.length(); i++) {
            badCharIndex.put(needle.charAt(i), i);
        }
    }

    private void generateGS(String needle, int[] suffix, boolean[] prefix) {
        int m = needle.length();
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        // 将下标从 0 到 i 的子串 needle[0 .. i] 与整个模式串进行比较，求公共后缀子串
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;  // 公共后缀子串的长度
            while (j >= 0 && needle.charAt(j) == needle.charAt(m - 1 - k)) {
                k++;  // 长度加一
                suffix[k] = j;  // 记录公共后缀子串在 needle[0 .. i] 中的起始下标
                j--;  // 尝试增大公共后缀子串
            }
            if (j == -1) {
                prefix[k] = true;  // 公共后缀子串也是模式串的前缀子串
            }
        }
    }

}
