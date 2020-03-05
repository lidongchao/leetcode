package distributeCandiesToPeople1103;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution2 solution = new Solution2();

        System.out.println(Arrays.toString(solution.distributeCandies(7,4)));  // [1,2,3,1]

        System.out.println(Arrays.toString(solution.distributeCandies(10,3)));  // [5,2,3]

        System.out.println(Arrays.toString(solution.distributeCandies(60,4)));  // [15,18,15,12]

        System.out.println(Arrays.toString(solution.distributeCandies(60,5)));  // [12,9,11,13,15]

    }

    private static boolean assertTrue(int[] src, int[] dst) {
        if (src.length != dst.length) {
            return false;
        }
        for (int i = 0; i < src.length; i++) {
            if (src[i] != dst[i]) {
                return false;
            }
        }
        return true;
    }
}
