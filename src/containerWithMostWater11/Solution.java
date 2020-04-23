package containerWithMostWater11;

/**
 * 思路：双指针
 *
 * 开始的时候两个指针分别指向第一个高度和最后一个高度，计算体积作为第一个版本。
 *
 * 如果两个指针分别为 i 和 j，那么体积公式为 (j-i) * min(h[j], h[i])
 *
 * 接着考虑让两个指针向中间移动，j-i 会减小，但 min(h[j], h[i]) 可能会减小，也可能会增大，所以应该怎么移动两个指针？
 *
 * 不妨假设 h[i] < h[j]，体积公式变为 (j-i) * h[i]。如果移动 j 为 j-1，体积公式为 (j-i-1) * min(h[i], h[j-1]) ，和之前的体积对比，
 * (j-i-1) < (j-i)             ====>
 * min(h[i], h[j-1]) <= h[i]   ====> (j-i-1) * min(h[i], h[j-1]) < (j-i) * h[i]
 * 体积必然变小。所以只能移动 i，即移动高度较低的指针。
 *
 * 所以每次移动规则是：高度较低的指针向中间移动一格 (未优化版)，
 * 或高度较低的指针向中间移动时，跳过比自身更低的位置，直接到达比自己更高的高度 (优化版)
 *
 * 移动后，再次计算体积，和已经记录的最大体积作为对比。
 *
 * 如果两个指针没有碰撞在一起，则仍需要继续移动指针，直到 i == j
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了99.33%的用户
 * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了38.57%的用户
 */
class Solution {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param height 可供选择作为容器边缘的高度
     * @return 容器的体积
     */
    public int maxArea(int[] height) {
        int max = 0;
        int p = 0, q = height.length - 1;

        while (p != q) {
            // 计算 p q 作为容器的体积，和最大值比较
            max = Math.max(max, area(height, p, q));
            // p q 向中间收缩，h[q] 更小，移动 q
            if (height[p] >= height[q]) {
                // 1. 未优化版
                // q--;
                // 2. 优化版，跳过比 h[q] 还要小的点，避免无意义的计算
                boolean isContinue = false;
                for (int i = q - 1; i > p; i--) {
                    // 找到比 h[q] 更大的点，q 移动到该点
                    if (height[i] > height[q]) {
                        q = i;
                        isContinue = true;
                        break;
                    }
                }
                // p q 之间没有发现 h[q] 更大的点，结束
                if (!isContinue) break;
            }
            // h[p] 更小，移动 p
            else {
                // 1. 未优化版
                // p++;
                // 2. 优化版，跳过比 h[p] 还要小的点，避免无意义的计算
                boolean isContinue = false;
                for (int i = p + 1; i < q; i++) {
                    // 找到比 h[p] 更大的点，p 移动到该点
                    if (height[i] > height[p]) {
                        p = i;
                        isContinue = true;
                        break;
                    }
                }
                // p q 之间没有发现 h[p] 更大的点，结束
                if (!isContinue) break;
            }
        }

        return max;
    }

    private int area(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
