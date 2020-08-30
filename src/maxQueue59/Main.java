package maxQueue59;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        String[] operators_1 = {"MaxQueue","push_back","push_back","max_value","pop_front","max_value"};
        int[][] operands_1 = {{},{1},{2},{},{},{}};
        Integer[] expect_1 = {null, null, null, 2, 1, 2};
        AssertUtils.assertEqualsArray(expect_1, operateQueue(operators_1, operands_1));

        String[] operators_2 = {"MaxQueue","max_value","pop_front","max_value","push_back","max_value","pop_front","max_value","pop_front","push_back","pop_front","pop_front","pop_front","push_back","pop_front","max_value","pop_front","max_value","push_back","push_back","max_value","push_back","max_value","max_value","max_value","push_back","pop_front","max_value","push_back","max_value","max_value","max_value","pop_front","push_back","push_back","push_back","push_back","pop_front","pop_front","max_value","pop_front","pop_front","max_value","push_back","push_back","pop_front","push_back","push_back","push_back","push_back","pop_front","max_value","push_back","max_value","max_value","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","push_back","push_back","pop_front","max_value","pop_front","max_value","max_value","max_value","pop_front","push_back","pop_front","push_back","push_back","pop_front","push_back","pop_front","push_back","pop_front","pop_front","push_back","pop_front","pop_front","pop_front","push_back","push_back","max_value","push_back","pop_front","push_back","push_back","pop_front"};
        int[][] operands_2 = {{},{},{},{},{46},{},{},{},{},{868},{},{},{},{525},{},{},{},{},{123},{646},{},{229},{},{},{},{871},{},{},{285},{},{},{},{},{45},{140},{837},{545},{},{},{},{},{},{},{561},{237},{},{633},{98},{806},{717},{},{},{186},{},{},{},{},{},{},{268},{},{29},{},{},{},{},{866},{},{239},{3},{850},{},{},{},{},{},{},{},{310},{},{674},{770},{},{525},{},{425},{},{},{720},{},{},{},{373},{411},{},{831},{},{765},{701},{}};
        Integer[] expect_2 = {null,-1,-1,-1,null,46,46,-1,-1,null,868,-1,-1,null,525,-1,-1,-1,null,null,646,null,646,646,646,null,123,871,null,871,871,871,646,null,null,null,null,229,871,837,285,45,837,null,null,140,null,null,null,null,837,806,null,806,806,545,806,806,806,null,561,null,237,806,806,806,null,633,null,null,null,98,866,806,866,866,866,717,null,186,null,null,268,null,29,null,866,239,null,3,850,310,null,null,770,null,674,null,null,770};
        AssertUtils.assertEqualsArray(expect_2, operateQueue(operators_2, operands_2));


    }

    private static Integer[] operateQueue(String[] operators, int[][] operands) throws IllegalStateException {
        MaxQueue obj = new MaxQueue();
        List<Integer> res = new ArrayList<>(operators.length);
        for (int i = 0; i < operators.length; i++) {
            switch (operators[i]) {
                case "MaxQueue":
                    if (i != 0) throw new IllegalStateException();
                    res.add(null);
                    break;
                case "push_back":
                    obj.push_back(operands[i][0]);
                    res.add(null);
                    break;
                case "pop_front":
                    res.add(obj.pop_front());
                    break;
                case "max_value":
                    res.add(obj.max_value());
                    break;
                default:
                    break;
            }
        }
        return res.toArray(new Integer[0]);
    }


}
