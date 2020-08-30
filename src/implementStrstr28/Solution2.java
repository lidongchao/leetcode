package implementStrstr28;

/**
 * 思路 2：RK 算法
 *
 * RK 算法的全称叫 Rabin-Karp 算法，是由它的两位发明者 Rabin 和 Karp 的名字来命名的。
 * RK 算法的思路是这样的：我们通过哈希算法对主串中的 n-m+1 个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。
 * 如果某个子串的哈希值与模式串相等，那就说明对应的子串和模式串匹配了（先不考虑哈希冲突的问题）。
 *
 * 如何快速计算每个子串的哈希值是算法的关键。
 *
 * 我们假设要匹配的字符串的字符集中只包含 K 个字符，我们可以用一个 K 进制数来表示一个子串，这个 K 进制数转化成十进制数，作为子串的哈希值。
 * 例如，子串 ABC 可以表示为 hash("ABC") = charToInt('A') * K * K + charToInt('B') * K + charToInt('C')
 *
 * 相邻两个子串可以利用彼此之间的交集，快速由其中一个推导出另外一个。
 * 例如，子串 ABC 到子串 BCD，可以表示为 hash("BCD") = (hash("ABC") - charToInt('A') * K * K) * K + charToInt('D')
 *
 * 如果希望不产生哈希冲突，那么 K 和 m 越大，哈希值的范围也就越大；相反，如果希望有一个哈希函数能将哈希值压缩到 Int 范围，
 * 那么就必须允许哈希冲突。解决哈希冲突的方法就是当哈希值相同时，重新比较一下子串和模式串。
 *
 * 时间复杂度 O(n)
 *
 * -- 极客时间《数据结构与算法之美》 32 | 字符串匹配基础（上）：如何借助哈希算法实现高效字符串匹配？
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了42.18%的用户
 * 内存消耗 :38.8 MB, 在所有 Java 提交中击败了5.43%的用户
 */
public class Solution2 {
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
        if (n < m) return -1;

            int base = 'z' - 'A' + 1;  // 基底 58
        long modulus = (1L << 62) - 1;  // 防止溢出

        // 计算并存储 needle 的哈希值，以及 haystack 中从起始位置开始且与 needle 等长的子字符串的哈希值
        long hashOfNeedle = 0;
        long hashOfSubHayStack = 0;
        for (int i = 0; i < m; i++) {
            hashOfNeedle = (hashOfNeedle * base + charToInt(needle, i)) & modulus;
            hashOfSubHayStack = (hashOfSubHayStack * base  + charToInt(haystack, i)) & modulus;
        }

        if (hashOfNeedle == hashOfSubHayStack) {
            return 0;
        }

        long baseM = 1;  // M 最高位的基底，以支持快速计算新的哈希值
        for (int i = 1; i < m; i++) {
            baseM = (baseM * base) & modulus;
        }

        // 向后移动 haystack 中子字符串的起始位置，保证长度不变，计算新的哈希值，判断是否相等
        for (int end = m; end < n; end++) {
            // "ABCD" ===> hash("BCD") = (hash("ABC") - charToInt('A') * K * K) * K + charToInt('D')
            hashOfSubHayStack = ((hashOfSubHayStack - charToInt(haystack, end-m) * baseM) * base + charToInt(haystack, end)) & modulus;
            // 判断哈希值相等的情况下还需要再判断字符串是否相等，避免哈希冲突
            if (hashOfNeedle == hashOfSubHayStack && needle.compareTo(haystack.substring(end - m + 1, end + 1)) == 0) {
                return end - m + 1;
            }
        }

        return -1;
    }

    private static int charToInt(String s, int idx) {
        return s.charAt(idx) - 'A';
    }
}
