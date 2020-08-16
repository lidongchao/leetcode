package minimumCostToCutAStick5486;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 思路 1：贪心，无法找到最优解，只能找到次优解
 */
public class Solution1 {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        Queue<Node> queue = new PriorityQueue<>();
        int cost = 0;

        Node first = new Node(0, cuts[0], null);
        queue.add(first);
        Node prev = first;
        for (int i = 0; i < cuts.length - 1; i++) {
            Node node = new Node(cuts[i], cuts[i + 1], prev);
            queue.add(node);
            prev = node;
        }
        Node last = new Node(cuts[cuts.length - 1], n, prev);
        queue.add(last);

        while (queue.size() > 1) {
            Node node = queue.poll();
            if (node.prev == null) {
                queue.remove(node.next);
                node.merge(node.next);
            } else if (node.next == null) {
                queue.remove(node.prev);
                node.merge(node.prev);
            } else {
                Node left = node.prev;
                Node right = node.next;
                if (left.compareTo(right) <= 0) {
                    queue.remove(left);
                    node.merge(left);
                } else {
                    queue.remove(right);
                    node.merge(right);
                }
            }
            queue.add(node);
            cost += node.val;
        }
        return cost;
    }

    private static class Node implements Comparable<Node> {
        int val;
        int start;
        int end;
        Node prev;
        Node next;
        Node(int start, int end, Node prev) {
            this.val = end - start;
            this.start = start;
            this.end = end;
            this.prev = prev;
            if (prev != null) {
                prev.next = this;
            }
        }

        public void merge(Node o) {
            if (this.end == o.start) {
                this.val += o.val;
                this.end = o.end;
                this.next = o.next;
                if (o.next != null) {
                    o.next.prev = this;
                }
            } else if (this.start == o.end) {
                this.val += o.val;
                this.start = o.start;
                this.prev = o.prev;
                if (o.prev != null) {
                    o.prev.next = this;
                }
            } else {
                throw new IllegalStateException("two node not near by");
            }
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
