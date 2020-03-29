package compressStringLcci01_06;

/**
 * 思路 1：遍历每个字符，记录每个字符连续的次数，遇到不同的字符则触发压缩
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution1 {
    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/compress-string-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param S 待压缩的字符串
     * @return 压缩后的字符串
     */
    public String compressString(String S) {
        if (null == S || S.length() == 0) return S;
        StringBuilder sb = new StringBuilder(S.length());
        // 存储的字符
        char holder = ' ';
        // 该存储字符的次数
        int times = 0;
        for (char c : S.toCharArray()) {
            // 遇到不同的字符
            if ( c != holder) {
                // 压缩已存储的字符
                if (times != 0) {
                    sb.append(holder).append(times);
                }
                // 更换存储的字符，重新计数
                holder = c;
                times = 1;
            } else {
                // 遇到相同的字符，计数加一
                times++;
            }
        }
        // 将最后存储的字符压缩
        sb.append(holder).append(times);
        if (sb.length() < S.length()) return sb.toString();
        return S;
    }
}
