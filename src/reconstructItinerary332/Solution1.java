package reconstructItinerary332;

import java.util.*;

/**
 * 思路 1：DFS + 回溯
 *
 * 执行用时：22 ms, 在所有 Java 提交中击败了7.87%的用户
 * 内存消耗：40.5 MB, 在所有 Java 提交中击败了32.43%的用户
 */
class Solution1 {
    /**
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
     *
     * 说明:
     * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
     * 所有的机场都用三个大写字母表示（机场代码）。
     * 假定所有机票至少存在一种合理的行程。
     *
     * 示例 1:
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     *
     * 示例 2:
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param tickets 二维数组表示的机票
     * @return 安排好的行程
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        ticketMap = new HashMap<>();
        ans = new LinkedList<>();

        // tickets.sort(Comparator.comparing(o -> (o.get(0) + o.get(1))));

        for (List<String> t : tickets) {
            ticketMap.computeIfAbsent(t.get(0), x -> new PriorityQueue<>()).offer(new Ticket(t.get(0), t.get(1)));
        }
        ans.add("JFK");
        dfs("JFK", 0, tickets.size());
        return ans;
    }

    private boolean dfs(String city, int cur, int max) {
        if (cur == max) {
            return true;
        }
        if (ticketMap.containsKey(city)) {
            for (Ticket ticket : ticketMap.get(city)) {
                if (!ticket.used) {
                    ans.add(ticket.to);
                    ticket.used = true;
                    if (dfs(ticket.to, cur + 1, max)) {
                        // 不断遍历和回溯，直到找到一条能够完整访问所有节点的路径
                        return true;
                    } else {
                        ans.remove(ans.size() - 1);
                        ticket.used = false;
                    }
                }
            }
        }
        return false;
    }

    // private Map<String, List<Ticket>> ticketMap;
    private Map<String, PriorityQueue<Ticket>> ticketMap;
    private List<String> ans;

    private final static class Ticket implements Comparable<Ticket> {
        String from;
        String to;
        boolean used;
        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
            this.used = false;
        }

        @Override
        public int compareTo(Ticket o) {
            return (this.from + this.to).compareTo(o.from + o.to);
        }
    }
}
