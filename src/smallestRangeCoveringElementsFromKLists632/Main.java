package smallestRangeCoveringElementsFromKLists632;

import utils.AssertUtils;
import utils.GeneratorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Answer answer = new Answer();

        for (int times = 0; times < 10; times++) {
            List<List<Integer>> nums = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int[] a = GeneratorUtils.generateRandomArray(1, 100000, -100000, 100000);
                Arrays.sort(a);
                nums.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
            }
            long startTime = System.currentTimeMillis();
            int[] expect = answer.smallestRange(nums);
            long midTime = System.currentTimeMillis();
            int[] actual = solution.smallestRange(nums);
            long endTime = System.currentTimeMillis();
            AssertUtils.assertEqualsArray(expect, actual);
            System.out.println("Time of expect: " + (midTime - startTime) + ". Time of actual: " + (endTime - midTime));
        }


    }
}
