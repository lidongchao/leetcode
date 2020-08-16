package integerBreak342;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inputs = {2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,20 ,30 ,40};
        int[] expects = {1, 2, 4, 6, 9, 12, 18, 27, 36, 1458, 59049, 2125764};
        int[] outputs = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            outputs[i] = solution.integerBreak(inputs[i]);
        }
        AssertUtils.assertEqualsIntArray(expects, outputs);

    }
}
