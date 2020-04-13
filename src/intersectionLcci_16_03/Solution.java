package intersectionLcci_16_03;

/**
 * 思路：数学公式求解
 *
 * 一条直线可以表示成参数方程式
 * x = x1 + t1 * (x2 - x1)
 * y = y1 + t1 * (y2 - y1)
 *
 * 当 0 <= t1 <= 1 时，代表 (x1,y1) 到 (x2,y2) 的线段
 *
 * 将两条线段用公式表示出来，再求解
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :38.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
     *
     * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
     *
     * 提示：
     *
     * 坐标绝对值不会超过 2^7
     * 输入的坐标均是有效的二维坐标
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param start1 第一条线段的起点
     * @param end1 第一条线段的终点
     * @param start2 第二条线段的起点
     * @param end2 第二条线段的终点
     * @return 交点坐标
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;
        double x4;
        double y4;

        // 先排序，再赋值，保证线段重叠存在多个交点时，起点比终点的优先级更高
        if (start1[0] < end1[0] || (start1[0] == end1[0] && start1[1] <= end1[1])) {
            x1 = start1[0];
            y1 = start1[1];
            x2 = end1[0];
            y2 = end1[1];
        } else {
            x2 = start1[0];
            y2 = start1[1];
            x1 = end1[0];
            y1 = end1[1];
        }

        if (start2[0] < end2[0] || (start2[0] == end2[0] && start2[1] <= end2[1])) {
            x3 = start2[0];
            y3 = start2[1];
            x4 = end2[0];
            y4 = end2[1];
        } else {
            x4 = start2[0];
            y4 = start2[1];
            x3 = end2[0];
            y3 = end2[1];
        }

        // 平行
        if ((x2-x1) * (y4-y3) == (y2-y1) * (x4-x3)) {
            // 一条直线
            if ((x3-x1) * (y3-y2) == (y3-y1) * (x3-x2)) {
                // 一条竖线
                if (x1 == x2) {
                    // 不相交
                    if (y2 < y3 || y4 < y1) return new double[]{};
                    // (x3,y3) 在第一条线段内
                    if (y1 < y3) return new double[]{x3, y3};
                    // (x1,y1) 在第二条线段内
                    return new double[]{x1, y1};

                }
                // (x3,y3) 与第一条线段的关系
                double t3_12 = (x3 - x1) / (x2 - x1);
                // (x4,y4) 与第一条线段的关系
                double t4_12 = (x4 - x1) / (x2 - x1);

                // (x3,y3) < (x1,y1) < (x2,y2)
                if (t3_12 < 0) {
                    // (x3,y3) < (x4,y4) < (x1,y1) < (x2,y2)
                    if (t4_12 < 0) return new double[]{};
                    // (x3,y3) < (x1,y1) <= (x4,y4) < (x2,y2)
                    // (x3,y3) < (x1,y1) < (x2,y2) <= (x4,y4)
                    else return new double[]{x1, y1};
                }
                // (x1,y1) < (x2,y2) < (x3,y3) < (x4,y4)
                if (t3_12 > 1) return new double[]{};
                // (x1,y1) < (x3,y3) <= (x2,y2)
                return new double[]{x3, y3};
            }
            // 两条直线
            else return new double[]{};
        }
        // 相交
        else {
            double t1 = ((x3 - x1) * (y4 - y3) - (y3 - y1) * (x4 - x3))
                    / ((x2-x1) * (y4-y3) - (y2-y1) * (x4-x3));

            double t2 = ((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1))
                    / ((x2-x1) * (y4-y3) - (y2-y1) * (x4-x3));

            // 有交点
            if (0 <= t1 && t1 <= 1 && 0 <= t2 && t2 <= 1) {
                return new double[]{x1 + t1 * (x2 - x1), y1 + t1 * (y2 - y1)};
            }
            // 无交点
            else return new double[]{};
        }
    }
}
