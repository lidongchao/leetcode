package cloneGraph133;

import utils.AssertUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[][] expect = {{2,4},{1,3},{2,4},{1,3}};
        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(convertMatrixToGraph(expect));
        int[][] actual = convertGraphToMatrix(clonedGraph);
        AssertUtils.assertEquals2DArray(expect, actual);

    }

    /**
     * 将二维数组转换为图
     * 要求：每个节点的值都和它的索引相同，即相同且从 1 开始递增
     * @param matrix 二维数组
     * @return 图的任意一个点
     */
    private static Node convertMatrixToGraph(int[][] matrix) {
        if (matrix.length == 0) return null;

        Map<Integer, Node> convertedNodeMap = new HashMap<>();
        for (int i = 1; i <= matrix.length; i++) {
            Node node = convertedNodeMap.computeIfAbsent(i, Node::new);
            for (int neighbor : matrix[i - 1]) {
                node.neighbors.add(convertedNodeMap.computeIfAbsent(neighbor, Node::new));
            }
        }
        return convertedNodeMap.get(1);
    }

    /**
     * 将图转换为二维数组
     * 要求：每个节点的值都和它的索引相同，即相同且从 1 开始递增
     * @param node 图的任意一个点
     * @return 二维数组
     */
    private static int[][] convertGraphToMatrix(Node node) {
        if (node == null) return new int[][]{};

        Map<Integer, List<Integer>> convertedNodeMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : head.neighbors) {
                neighbors.add(neighbor.val);
                if (!convertedNodeMap.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                }
            }
            convertedNodeMap.put(head.val, neighbors);
        }

        int[][] res = new int[convertedNodeMap.size()][];
        for (int i = 0; i < res.length; i++) {
            List<Integer> neighbors = convertedNodeMap.get(i + 1);
            res[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
        }
        return res;
    }
}
