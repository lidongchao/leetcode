package cloneGraph133;

import java.util.HashMap;

/**
 * 思路：DFS
 *
 * 执行用时：37 ms, 在所有 Java 提交中击败了53.46%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了6.25%的用户
 */
class Solution {
    /**
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     *  
     * 测试用例格式：
     * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
     * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
     * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
     *
     * 提示：
     * 节点数不超过 100 。
     * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
     * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
     * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
     * 图是连通图，你可以从给定节点访问到所有节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/clone-graph
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param node 无向连通图的一个点
     * @return 拷贝后的无向连通图的任意一个点
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> clonedNodeMap = new HashMap<>();
        return cloneGraph(node, clonedNodeMap);
    }

    private Node cloneGraph(Node node, HashMap<Node, Node> clonedNodeMap) {
        if (clonedNodeMap.containsKey(node)) {
            return clonedNodeMap.get(node);
        }

        // 先放入 Map，再 DFS 遍历相邻节点，避免死循环
        Node newNode = new Node(node.val);
        clonedNodeMap.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor, clonedNodeMap));
        }
        return newNode;
    }


}