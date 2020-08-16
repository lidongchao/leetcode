package serializeAndDeserializeBinaryTree297;

import utils.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 * 你可以将以下二叉树：
 *   1
 *  / \
 * 2   3
 *    / \
 *   4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，
 * 你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行用时 :85 ms, 在所有 Java 提交中击败了23.81%的用户
 * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了21.43%的用户
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        // 存储序列化字符串，逐层序列化，层与层之间用分号区分，层内存储当前层的所有节点，节点之间用逗号区分，
        // 每个节点存储为满二叉树时从左到当前节点的序号和节点值，用冒号区分。
        // 示例二叉树会被序列化为 "1:1;1:2,2:3;3:4,4:5"
        StringBuilder sb = new StringBuilder();

        // BFS 辅助队列

        // 序列化根节点
        HashMap<Integer, TreeNode> rootMap = new HashMap<>();
        rootMap.put(1, root);
        sb.append(String.format("1:%d", root.val));

        // 初始化队列
        Queue<Map.Entry<Integer, TreeNode>> queue = new LinkedList<>(rootMap.entrySet());

        // BFS
        while (!queue.isEmpty()) {
            // 逐层遍历，第一层为根节点
            int size = queue.size();
            Map<Integer, TreeNode> map = new HashMap<>();  // 存储当前层的所有子节点
            boolean haveValue = false;  // 标记是否有节点被序列化
            StringBuilder ssb = new StringBuilder();  // 序列化当前层的所有子节点
            for (int i = 0; i < size; i++) {
                Map.Entry<Integer, TreeNode> nodeEntry = queue.poll();
                assert nodeEntry != null;
                int sequence = nodeEntry.getKey();  // 节点的序号，用于计算子节点的序号
                TreeNode node = nodeEntry.getValue();  // 节点
                if (node.left != null) {  // 序列化左子节点
                    if (!haveValue) {
                        haveValue = true;
                    }
                    map.put(sequence * 2 - 1, node.left);
                    ssb.append(String.format("%d:%d,", sequence * 2 - 1, node.left.val));
                }
                if (node.right != null) {  // 序列化右子节点
                    if (!haveValue) {
                        haveValue = true;
                    }
                    map.put(sequence * 2, node.right);
                    ssb.append(String.format("%d:%d,", sequence * 2, node.right.val));
                }
            }
            if (haveValue) {
                ssb.deleteCharAt(ssb.length()-1);
                sb.append(';');
                sb.append(ssb);
            }
            queue.addAll(map.entrySet());  // 将所有子节点加入队列中
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] tree = data.split(";");
        TreeNode root = new TreeNode(Integer.parseInt(tree[0].split(":")[1]));
        HashMap<Integer, TreeNode> rootMap = new HashMap<>();
        rootMap.put(1, root);

        Queue<Map.Entry<Integer, TreeNode>> queue = new LinkedList<>(rootMap.entrySet());

        // 逐层进行反序列化
        for (int i = 1; i < tree.length; i++) {
            // 得到该层的所有节点，存储在哈希表中
            String[] nodes = tree[i].split(",");
            HashMap<Integer, TreeNode> map = new HashMap<>();
            for (String node : nodes) {
                String[] kv = node.split(":");
                map.put(Integer.valueOf(kv[0]), new TreeNode(Integer.parseInt(kv[1])));
            }
            // 遍历上一层的所有节点，在当前层中查找是否有左右子节点
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Map.Entry<Integer, TreeNode> nodeEntry = queue.poll();
                assert nodeEntry != null;
                int sequence = nodeEntry.getKey();  // 上一层节点的序号，用于计算其子节点的序号
                TreeNode node = nodeEntry.getValue();
                if (map.containsKey(sequence * 2 - 1)) {  // 找到左子节点
                    node.left = map.get(sequence * 2 - 1);
                }
                if (map.containsKey(sequence * 2)) {  // 找到右子节点
                    node.right = map.get(sequence * 2);
                }
            }
            queue.addAll(map.entrySet());
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
