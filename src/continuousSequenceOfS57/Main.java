package continuousSequenceOfS57;

import utils.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        // [2, 3, 4]
        // [4, 5]
        ArrayUtils.print2DimArray(solution.findContinuousSequence(9));

        // [1, 2, 3, 4, 5]
        // [4, 5, 6]
        // [7, 8]
        ArrayUtils.print2DimArray(solution.findContinuousSequence(15));

        // [36 , ... , 444]
        // [534, ... , 693]
        // [975, ... , 1070]
        // [3052, ... , 3083]
        // [6537, ... , 6551]
        // [19630, 19631, 19632, 19633, 19634]
        // [32719, 32720, 32721]
        ArrayUtils.print2DimArray(solution.findContinuousSequence(98160));
    }
}
