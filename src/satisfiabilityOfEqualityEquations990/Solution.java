package satisfiabilityOfEqualityEquations990;

import java.util.*;

/**
 * 思路：并查集
 *
 * 执行用时 :8 ms, 在所有 Java 提交中击败了7.81%的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了16.67%的用户
 */
class Solution {
    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
     * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     *
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
     *
     * 提示：
     *
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {

        Set<List<String>> equalSet = new HashSet<>();  // 存放应该在一组的元素 (可以不构建，一边遍历筛选，一边使用)
        Set<List<String>> nonEqualSet = new HashSet<>();  // 存放不应该在一组的元素 (同样可以不用构建)

        Map<String, String> elementMap = new HashMap<>();  // 存放每个元素的父元素，初始化为自身 (都是小写字母，可以简化为数组)

        // 处理每个输入
        for (String equation : equations) {
            String s1 = equation.substring(0, 1);  // 第一个元素
            String s2 = equation.substring(3, 4);  // 第二个元素

            // 设置父元素 Map
            elementMap.put(s1, s1);
            elementMap.put(s2, s2);

            // 拼接成一组，根据 == 和 != 放置在不同的容器中
            List<String> list = new ArrayList<>(2);
            list.add(s1);
            list.add(s2);
            list.sort(Comparator.naturalOrder());
            if (equation.substring(1,2).equals("!")) {
                nonEqualSet.add(list);
            } else {
                equalSet.add(list);
            }
        }

        // 初始化并查集
        UnionFind unionFind = new UnionFind(elementMap);

        // 构建并查集
        for (List<String> list : equalSet) {
            unionFind.union(list.get(0), list.get(1));
        }

        // 查询是否有不应该在一组的元素实际上分到了一组
        for (List<String> list : nonEqualSet) {
            if (unionFind.find(list.get(0)).equals(unionFind.find(list.get(1)))) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {
        Map<String, String> parent;

        UnionFind(Map<String, String> elementMap) {
            this.parent = elementMap;
        }

        String find(String s) {
            if (!parent.get(s).equals(s)) parent.put(s, find(parent.get(s)));
            return parent.get(s);
        }

        void union(String s1, String s2) {
            String root1 = find(s1);
            String root2 = find(s2);
            if (!root1.equals(root2)) {
                if (root1.compareTo(root2) > 0) {
                    parent.put(root1, root2);
                } else {
                    parent.put(root2, root1);
                }
            }
        }

    }
}
