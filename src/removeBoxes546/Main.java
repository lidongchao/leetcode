package removeBoxes546;

import utils.AssertUtils;
import utils.GeneratorUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Answer answer = new Answer();
        AssertUtils.mute();

        for (int i = 0; i < 1000; i++) {
            int[] boxes = GeneratorUtils.generateRandomArray(1, 100, 1, 100);
            if (!AssertUtils.assertEqualsInteger(answer.removeBoxes(boxes), solution.removeBoxes(boxes))) {
                System.out.println(Arrays.toString(boxes));
            }
        }

    }
}
