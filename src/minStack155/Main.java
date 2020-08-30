package minStack155;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] operators_1 = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        int[][] operands_1 = {{},{-2},{0},{-3},{},{},{},{}};
        Integer[] expect_1 = {null, null, null, null, -3, null, 0, -2};
        AssertUtils.assertEqualsArray(expect_1, operateStack(operators_1, operands_1));


    }

    private static Integer[] operateStack(String[] operators, int[][] operands) throws IllegalStateException {
        MinStack obj = new MinStack();
        List<Integer> res = new ArrayList<>(operators.length);
        for (int i = 0; i < operators.length; i++) {
            switch (operators[i]) {
                case "MinStack":
                    if (i != 0) throw new IllegalStateException();
                    res.add(null);
                    break;
                case "push":
                    obj.push(operands[i][0]);
                    res.add(null);
                    break;
                case "pop":
                    obj.pop();
                    res.add(null);
                    break;
                case "top":
                    res.add(obj.top());
                    break;
                case "getMin":
                    res.add(obj.getMin());
                default:
                    break;
            }
        }
        return res.toArray(new Integer[0]);
    }
}
