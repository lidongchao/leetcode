package magicIndexLcci_08_03;

import utils.AssertUtils;
import utils.GeneratorUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        for (int i = 0; i < 1000; i++) {
            int[] arr = GeneratorUtils.generateRandomArray(100, 100, -50, 150);
            Arrays.sort(arr);

            int magicIndex1 = solution1.findMagicIndex(arr);
            int magicIndex2 = solution2.findMagicIndex(arr);
            AssertUtils.assertEquals(magicIndex1, magicIndex2);
        }
    }
}
