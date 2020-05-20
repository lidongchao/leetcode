package courseScheduleII210;

import java.util.*;

/**
 * 思路 2：基于 DFS 的拓扑排序
 *
 * 执行用时 :14 ms, 在所有 Java 提交中击败了41.38%的用户
 * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了93.33%的用户
 */
class Solution2 {
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
        List<Integer> ans;  // 存储已经完成遍历的节点
        int[] degree;  // 存储节点的入度
        List<List<Integer>> map;  // 存储课程图
        Queue<Integer> queue;  // 存储当前入度为 0 的节点

        ans = new ArrayList<>();
        degree = new int[numCourses];
        map = new ArrayList<>(numCourses);
        queue = new ArrayDeque<>(numCourses);

        // 初始化图
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }

        // 构造图
        for (int[] courseRelation : prerequisites) {
            map.get(courseRelation[1]).add(courseRelation[0]);
            degree[courseRelation[0]]++;
        }

        // 如果课程的入度为 0，说明没有前序课程，可以直接学习
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        // 广度优先遍历
        while (!queue.isEmpty()) {
            // 学习出列的课程
            Integer course = queue.poll();
            ans.add(course);
            // 该课程的所有后序课程入度减一，如果为 0，说明该后序课程可以直接学习
            for (int subCourse : map.get(course)) {
                degree[subCourse]--;
                if (degree[subCourse] == 0) {
                    queue.add(subCourse);
                }
            }
        }

        // 出现环，返回空数组
        if (ans.size() != numCourses) return new int[0];

        // 输出结果数组
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
