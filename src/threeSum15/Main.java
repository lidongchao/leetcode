package threeSum15;

import utils.ArrayUtils;
import utils.AssertUtils;
import utils.GeneratorUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        for (int i = 0; i < 100; i++) {
            int[] arr = GeneratorUtils.generateRandomArray(1, 1000, -1000, 1000);
            AssertUtils.assertEquals2DArray(
                    ArrayUtils.listTo2DIntArray(solution1.threeSum(arr)),
                    ArrayUtils.listTo2DIntArray(solution2.threeSum(arr)));

        }
    }
}
