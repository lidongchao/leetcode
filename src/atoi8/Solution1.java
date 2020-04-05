package atoi8;

/**
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了31.65%的用户
 * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了5.18%的用户
 */
class Solution1 {
    public int myAtoi(String str) {
        if (null == str) return 0;

        StringBuilder sb = new StringBuilder(str.length());

        boolean meetSign = false;
        boolean meetNum = false;
        boolean sign = true;

        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (c == ' ') {
                if (meetSign || meetNum) {
                    break;
                }
            }
            else if (c == '+') {
                if (!meetSign && !meetNum) {
                    meetSign = true;
                } else {
                    break;
                }
            }
            else if (c == '-') {
                if (!meetSign && !meetNum) {
                    sign = false;
                    sb.append("-");
                    meetSign = true;
                } else {
                    break;
                }
            }
            else if (c >= '0' && c <= '9') {
                sb.append(c);
                meetNum = true;
            } else {
                break;
            }
        }

        if (sb.length() == 0) return 0;
        if (sb.length() == 1 && (sb.charAt(0) == '+' || sb.charAt(0) == '-')) return 0;

        int ans;
        try {
            ans = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if (sign) {
                ans = Integer.MAX_VALUE;
            } else {
                ans = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}
