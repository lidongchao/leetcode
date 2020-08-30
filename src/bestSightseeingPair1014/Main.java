package bestSightseeingPair1014;

import utils.AssertUtils;
import utils.GeneratorUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        for (int i = 0; i < 100; i++) {
            int[] A = GeneratorUtils.generateRandomArray(1, 20, 1, 100);
            if (A.length < 2) continue;
            AssertUtils.assertEquals(solution1.maxScoreSightseeingPair(A), solution2.maxScoreSightseeingPair(A));
        }

    }
}
