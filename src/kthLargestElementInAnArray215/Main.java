package kthLargestElementInAnArray215;

import utils.AssertUtils;
import utils.GeneratorUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        for (int i = 0; i < 100; i++) {
            int[] nums = GeneratorUtils.generateRandomArray(1, 100, 0, 100);
            if (nums.length == 0) continue;
            int[] nums2 = Arrays.copyOf(nums, nums.length);
            int k = (int) (Math.random() * nums.length) + 1;
            AssertUtils.assertEqualsInteger(solution1.findKthLargest(nums, k), solution2.findKthLargest(nums2, k));
        }


    }
}
