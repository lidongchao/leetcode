package rectangleOverlap836;

/**
 * 思路 1：设定 rec1 = [x1, y1, x2, y2], rec2 = [x3, y3, x4, y4]
 * 那么根据 x1 x2 x3 x4 的位置可以确定 x 轴是否有交集
 * 再同样根据 y1 y2 y3 y4 的位置可以确定 y 轴是否有交集
 * (有个全场成立的条件是 x2 > x1、x4 > x3、y2 > y1、y4 > y3)
 * 当 x 轴和 y 轴同时有交集时，两个矩形相交
 * 另一方面，当 x 轴没有交集，或 y 轴没有交集，两个矩形不相交
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了5.49%的用户
 */
class Solution1 {
    /**
     * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
     * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
     * 给出两个矩形，判断它们是否重叠并返回结果。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rectangle-overlap/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param rec1 第一个矩形
     * @param rec2 第二个矩形
     * @return 是否相交
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        return lenOfOverlap(rec1[0], rec1[2], rec2[0], rec2[2]) != 0
//                && lenOfOverlap(rec1[1], rec1[3], rec2[1], rec2[3]) != 0;
//        return isOverlap(rec1[0], rec1[2], rec2[0], rec2[2])
//                && isOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }

//    /**
//     * 根据 x1 x2 x3 x4 的分布判断是否相交
//     * @param x1 第一个矩形的 x1/y1
//     * @param x2 第一个矩形的 x2/y1
//     * @param x3 第二个矩形的 x1/y1
//     * @param x4 第二个矩形的 x2/y1
//     * @return x/y 轴是否相交
//     */
//    private boolean isOverlap(int x1, int x2, int x3, int x4) {
//        if (x1 == x3) {
//            return true;
//        } else if (x1 < x3) {
//            if (x3 >= x2) return false;
//            else return true;
//        } else {
//            if (x1 >= x4) return false;
//            else return true;
//        }
//        ==>
//        return (x1 == x3) || ((x1 < x3) && (x3 < x2)) || ((x3 < x1) && (x1 < x4));
//        ==>
//        return !((x1 != x3) && ((x1 >= x3) || (x3 >= x2)) && ((x3 >= x1) || (x1 >= x4)));
//        ==>
//        return !((x3 >= x2) || (x1 >= x4));
//    }

//    /**
//     * 根据 x1 x2 x3 x4 的分布判断是否相交以及相交部分的长度
//     * @param x1 第一个矩形的 x1/y1
//     * @param x2 第一个矩形的 x2/y1
//     * @param x3 第二个矩形的 x1/y1
//     * @param x4 第二个矩形的 x2/y1
//     * @return x/y 轴相交的长度
//     */
//    private int lenOfOverlap(int x1, int x2, int x3, int x4) {
//        // 必定有交集
//        if (x1 == x3) {
//            return Math.min(x2, x4);
//        } else if (x1 < x3) {
//            // x1 < x2 <= x3 < x4，没有交集
//            if (x3 >= x2) return 0;
//            // x1 < x3 < x4 <= x2，有交集
//            else return Math.min(x2, x4) - x3;
//        } else {
//            // x3 < x4 <= x1 < x2，没有交集
//            if (x1 >= x4) return 0;
//            // x3 < x1 < x2 <= x4，有交集
//            else return Math.min(x2, x4) - x1;
//        }
//    }
}
