package courseScheduleII210;

import java.util.*;

/**
 * 思路 1：基于 DFS 的拓扑排序
 *
 * 执行用时 :9 ms, 在所有 Java 提交中击败了62.62%的用户
 * 内存消耗 :41.6 MB, 在所有 Java 提交中击败了93.33%的用户
 */
class Solution1 {
    /**
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     *
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     *
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses 课程数量
     * @param prerequisites 课程关系
     * @return 课程的学习顺序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new ArrayList<>();
        visited = new int[numCourses];
        map = new ArrayList<>(numCourses);
        invalid = false;

        // 初始化图
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }

        // 构造图
        for (int[] courseRelation : prerequisites) {
            map.get(courseRelation[1]).add(courseRelation[0]);
        }

        // 访问每个课程，且当前没有出现环
        for (int i = 0; i < numCourses && !invalid; i++) {
            dfs(i);
        }

        // 出现环，返回空数组
        if (invalid) return new int[0];

        // 反转结果数组并输出
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 深度优先遍历
    private void dfs(int c) {
        // 如果遍历到搜索中的课程，说明出现了环
        if (visited[c] == 1) {
            invalid = true;
            return;
        }
        // 已完成的课程无需再遍历
        if (visited[c] == 2) return;

        visited[c] = 1;  // 搜索中
        // 得到该课程的所有直接后序课程，依次遍历
        for (int course : map.get(c)) {
            dfs(course);
            if (invalid) return;
        }

        visited[c] = 2;  // 已完成
        ans.add(c);
    }

    private List<Integer> ans;  // 存储已经完成遍历的节点，最先完成的节点一定是最后才需要上的课程
    private int[] visited;  // 存储节点状态：0-未搜索，1-搜索中，2-已完成
    private List<List<Integer>> map;  // 存储课程图
    private boolean invalid;  // 标识是否发现了环

}
