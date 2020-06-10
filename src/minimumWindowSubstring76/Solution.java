package minimumWindowSubstring76;

import java.util.*;

/**
 * 思路：双指针、滑动窗口
 *
 * 代码框架：
 *
 * int left = 0, right = 0;
 *
 * while (right < s.size()) {
 *     // 增大窗口
 *     window.add(s[right]);
 *     right++;
 *
 *     while (window needs shrink) {
 *         // 缩小窗口
 *         window.remove(s[left]);
 *         left++;
 *     }
 * }
 *
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * valid
 * 执行用时 :21 ms, 在所有 Java 提交中击败了35.54%的用户
 * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了13.33%的用户
 *
 * checkContain()
 * 执行用时 :125 ms, 在所有 Java 提交中击败了8.52%的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了13.33%的用户
 */
class Solution {
    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     *
     * 示例：
     *
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     *
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 主字符串
     * @param t 从字符串
     * @return s 中包含 t 所有字符的最小子串
     */
    public String minWindow(String s, String t) {
        // 记录 t 中每一个字符出现的次数
        for (char c: t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0)+1);
            window.put(c, 0);
        }

        // 双指针指向当前判断的子串的头尾字符
        int left = 0;
        int right = 0;
        // 当前已有多少字符满足要求
        int valid = 0;

        // 初始化最小子串的起始位置和长度
        int index = -1;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 进行窗口内数据的一系列更新
            if (target.containsKey(c)) {
                window.put(c, window.get(c)+1);
                // 检查是否满足要求，只有到达门槛这一次才算
                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }
            // 右移窗口
            right++;

            // debug 输出的位置
            // System.out.println(String.format("window: [%d, %d)", left, right));

            // 判断左侧窗口是否要收缩
            while ( /**checkContain()**/ valid == target.size()) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 进行窗口内数据的一系列更新
                if (target.containsKey(d)) {
                    // 只有当即将更改状态时，才判断子串是否为更优解
                    // 因为最优解一定出现在头尾字符都属于 t 字符集的那一刻
                    if (right-left < len) {
                        len = right-left;
                        index = left;
                    }
                    // 检查是否不再满足要求，只有从门槛出来这一次才算
                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
                // 左移窗口
                left++;
            }
        }
        // 不存在起始位置，说明不存这样的子串
        if (index == -1) return "";

        return s.substring(index, index + len);

    }

    // 检查 s 当前子串的状态是否完全包含 t 的状态
    private boolean checkContain() {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (window.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> target = new HashMap<>();  // 记录 t 的状态
    private Map<Character, Integer> window = new HashMap<>();  // 记录 s 当前子串的状态
}
