package increasingSubsequences491;

import utils.AssertUtils;
import utils.GeneratorUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

//        for (int i = 0; i < 100; i++) {
//            int[] arr = GeneratorUtils.generateRandomArray(1, 15, -100, 100);
//            AssertUtils.assertEqualsInteger(solution1.findSubsequences(arr).size(),
//                    solution2.findSubsequences(arr).size());
//        }

        System.out.println(solution1.findSubsequences(new int[]{1, 3, 5, 5, 5, 7}));
        System.out.println(solution2.findSubsequences(new int[]{1, 3, 5, 5, 5, 7}));

    }
}
