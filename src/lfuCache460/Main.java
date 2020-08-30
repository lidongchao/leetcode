package lfuCache460;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
        cache.put(1, 1);
        cache.put(2, 2);
        AssertUtils.assertEquals(1, cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        AssertUtils.assertEquals(-1, cache.get(2));      // 返回 -1 (未找到key 2)
        AssertUtils.assertEquals(3, cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        AssertUtils.assertEquals(-1, cache.get(1));      // 返回 -1 (未找到 key 1)
        AssertUtils.assertEquals(3, cache.get(3));       // 返回 3
        AssertUtils.assertEquals(4, cache.get(4));       // 返回 4


        String[] operators_2 = {"LFUCache","put","get"};
        int[][] operands_2 = {{0},{0,0},{0}};
        Integer[] expect_2 = {null,null,-1};
        AssertUtils.assertEqualsArray(expect_2, operateQueue(operators_2, operands_2));


        String[] operators_3 = {"LFUCache","put","put","put","put","get"};
        int[][] operands_3 = {{2},{3,1},{2,1},{2,2},{4,4},{2}};
        Integer[] expect_3 = {null,null,null,null,null,2};
        AssertUtils.assertEqualsArray(expect_3, operateQueue(operators_3, operands_3));


        String[] operators_4 = {"LFUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"};
        int[][] operands_4 = {{3},{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},{1},{2},{3},{4},{5}};
        Integer[] expect_4 = {null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5};
        AssertUtils.assertEqualsArray(expect_4, operateQueue(operators_4, operands_4));


        String[] operators_5 = {"LFUCache","put","get","put","get","get"};
        int[][] operands_5 = {{1},{2,1},{2},{3,2},{2},{3}};
        Integer[] expect_5 = {null,null,1,null,-1,2};
        AssertUtils.assertEqualsArray(expect_5, operateQueue(operators_5, operands_5));


        String[] operators_6 = {"LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int[][] operands_6 = {{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};
        Integer[] expect_6 = {null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,-1,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null};
        AssertUtils.assertEqualsArray(expect_6, operateQueue(operators_6, operands_6));

    }

    private static Integer[] operateQueue(String[] operators, int[][] operands) throws IllegalStateException {

        if (!"LFUCache".equals(operators[0])) throw new IllegalStateException();
        List<Integer> res = new ArrayList<>(operators.length);
        LFUCache2 obj = new LFUCache2(operands[0][0]);
        res.add(null);
        for (int i = 1; i < operators.length; i++) {
            switch (operators[i]) {
                case "put":
                    obj.put(operands[i][0], operands[i][1]);
                    res.add(null);
                    break;
                case "get":
                    res.add(obj.get(operands[i][0]));
                    break;
                default:
                    break;
            }
        }
        return res.toArray(new Integer[0]);
    }


}
