package eightQueens;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        // 列表共 n 个元素，第 i 个元素记录第 i 行皇后的纵坐标。
        int[] res = new int[n];
        solve(res, n, 0);
        return result;

    }

    private void solve(int[] res, int n, int x) {
        if (x >= n) {
            result.add(generateList(res));
            return;
        }
        // 在当前第 x 行，枚举皇后是否可以放在第 y 列
        for (int y = 0; y < n; y++) {
            if (canPlace(res, x, y)) {
                res[x] = y;
                solve(res, n, x+1);
            }
        }
    }

    private boolean canPlace(int[] res, int x, int y) {
        for (int i = 0, j; i < x; i++) {
            j = res[i];
            if (j == y) return false;
            if (x - i == Math.abs(y - res[i])) return false;
        }
        return true;
    }

    private List<String> generateList(int[] res) {
        List<String> map = new ArrayList<>(res.length);
        for (int i : res) {
            StringBuilder sb = new StringBuilder();
            for (int star = 0; star < i; star++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int star = i+1; star < res.length; star++) {
                sb.append(".");
            }
            map.add(sb.toString());
        }
        return map;
    }

    private List<List<String>> result = new ArrayList<>();

}
