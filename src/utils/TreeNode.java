package utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import serializeAndDeserializeBinaryTree297.Codec;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" +
                "" + val +
                ", [" + left +
                ", " + right +
                "]}";
    }

    public String serialize() {
        Codec codec = new Codec();
        return codec.serialize(this);
    }

    public static TreeNode deserialize(String s) {
        Codec codec = new Codec();
        return codec.deserialize(s);
    }

}
