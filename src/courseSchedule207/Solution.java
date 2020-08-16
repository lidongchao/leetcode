package courseSchedule207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路：拓扑排序
 *
 * 通过拓扑排序寻找图是否存在环
 *
 * 执行用时：6 ms, 在所有 Java 提交中击败了64.90%的用户
 * 内存消耗：40.5 MB, 在所有 Java 提交中击败了38.15%的用户
 */
class Solution {
    /**
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     * 示例 1:
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     *
     * 示例 2:
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     *
     * 提示：
     * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 1 <= numCourses <= 10^5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses 课程数
     * @param prerequisites 课程依赖
     * @return 是否能够完成
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        @SuppressWarnings("unchecked") LinkedList<Integer>[] adj = new LinkedList[numCourses];  // 邻接矩阵
        int[] inDegree = new int[numCourses];  // 每个节点的入度

        // 构造邻接矩阵
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // 始终将入度为 0 的节点加入队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 每次取出一个入度为 0 的节点
            Integer poll = queue.poll();
            // 将该节点能够到达的其他所有节点的入度减一
            for (Integer next : adj[poll]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 结束时如果仍有入度不为 0 的节点，说明存在环
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
