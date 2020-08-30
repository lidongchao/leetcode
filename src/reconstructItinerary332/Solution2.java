package reconstructItinerary332;

import java.util.*;

/**
 * 思路 2：DFS + Hierholzer 算法
 *
 * Hierholzer 算法用于在连通图中寻找欧拉路径，其流程如下：
 * 1. 从起点出发，进行深度优先搜索。
 * 2. 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
 * 3. 如果没有可移动的路径，则将所在节点加入到栈中，并返回。
 *
 * 当我们顺序地考虑该问题时，我们也许很难解决该问题，因为我们无法判断当前节点的哪一个分支是「死胡同」分支。不妨倒过来思考。我们注意到只有那
 * 个入度与出度差为 11 的节点会导致死胡同。而该节点必然是最后一个遍历到的节点。我们可以改变入栈的规则，当我们遍历完一个节点所连的所有节点
 * 后，我们才将该节点入栈（即逆序入栈）。对于当前节点而言，从它的每一个非「死胡同」分支出发进行深度优先搜索，都将会搜回到当前节点。而从它的
 * 「死胡同」分支出发进行深度优先搜索将不会搜回到当前节点。也就是说当前节点的死胡同分支将会优先于其他非「死胡同」分支入栈。这样就能保证我们
 * 可以「一笔画」地走完所有边，最终的栈中逆序地保存了「一笔画」的结果。我们只要将栈中的内容反转，即可得到答案。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 执行用时：8 ms, 在所有 Java 提交中击败了74.15%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了59.46%的用户
 */
class Solution2 {
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
        ans = new ArrayList<>();

        for (List<String> ticket : tickets) {
            // 使用优先队列保证目的地按照字典序排序
            ticketMap.computeIfAbsent(ticket.get(0), x->new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(ans);  // dfs 得到的是逆序存储行程，需要变换为顺序
        return ans;
    }

    private void dfs(String city) {
        // 能继续前往下一个目的地，就优先前往
        if (ticketMap.containsKey(city)) {
            while (ticketMap.get(city).size() > 0) {
                // 每使用一张机票，就移除该机票，避免重复使用
                String dest = ticketMap.get(city).poll();
                dfs(dest);
            }
        }
        // 走到尽头才存储目的地
        ans.add(city);
    }

    private Map<String, PriorityQueue<String>> ticketMap;
    private List<String> ans;
}
