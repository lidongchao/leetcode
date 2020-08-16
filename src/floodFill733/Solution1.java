package floodFill733;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路 1：图、广度优先遍历
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了25.76%的用户
 * 内存消耗：40.8 MB, 在所有 Java 提交中击败了27.33%的用户
 */
class Solution1 {
    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，
     * 重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     * 最后返回经过上色渲染后的图像。
     *
     * 示例 1:
     * 输入:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析:
     * 在图像的正中间，(坐标(sr,sc)=(1,1)),
     * 在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，
     * 因为它不是在上下左右四个方向上与初始点相连的像素点。
     *
     * 注意:
     * image 和 image[0] 的长度在范围 [1, 50] 内。
     * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
     * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flood-fill
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param image 图像
     * @param sr 起点横坐标
     * @param sc 起点纵坐标
     * @param newColor 新颜色
     * @return 重新上色后的图像
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        if (row <= 0) return image;
        int col = image[0].length;
        if (col <= 0) return image;

        int color = image[sr][sc];  // 相同颜色才改变

        boolean[][] visited = new boolean[row][col];  // 记录已经访问过的像素点
        Queue<int[]> queue = new LinkedList<>();  // 记录所有正在访问的像素点

        // 从起点开始遍历
        queue.add(genPos(sr, sc));
        image[sr][sc] = newColor;
        visited[sr][sc] = true;

        // BFS
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            for (int[] dir : dirs) {
                int x = head[0] + dir[0];
                int y = head[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (image[x][y] != color) {
                    continue;
                }
                queue.add(genPos(x, y));
                image[x][y] = newColor;
            }
        }

        return image;
    }

    private int[] genPos(int x, int y) {
        return new int[]{x, y};
    }

    private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
}
