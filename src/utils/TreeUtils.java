package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    public static TreeNode construct(Integer[] nodeVal) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode root = null;
        for (int i = 0; i < nodeVal.length; i++) {
            Integer left = nodeVal[i];
            // 处理根结点
            if (null == root) {
                root = new TreeNode(left);
                treeNodeQueue.add(root);
                continue;
            }

            // 取出当前遍历的结点，添加其左右叶子结点
            TreeNode poll = treeNodeQueue.poll();

            // 添加左边叶子
            if (null != poll && null != left) {
                poll.left = new TreeNode(left);
                treeNodeQueue.add(poll.left);
            } else {
                treeNodeQueue.add(null);
            }

            // 添加右边叶子
            if (i + 1 < nodeVal.length){
                Integer right = nodeVal[i+1];
                if (null != poll && null != right) {
                    poll.right = new TreeNode(right);
                    treeNodeQueue.add(poll.right);
                } else {
                    treeNodeQueue.add(null);
                }
                i++;
            }

        }
        return root;
    }

    public static TreeNode find(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        TreeNode left = find(node.left, val);
        if (left != null) {
            return left;
        } else {
            TreeNode right = find(node.right, val);
            if (right != null) {
                return right;
            }
        }
        return null;
    }



}
