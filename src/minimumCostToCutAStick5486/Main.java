package minimumCostToCutAStick5486;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int n_1 = 7;
        int[] cuts_1 = new int[]{1,3,4,5};
        int expect_1 = 16;
        AssertUtils.assertEquals(expect_1, solution.minCost(n_1, cuts_1));

        int n_2 = 9;
        int[] cuts_2 = new int[]{5,6,1,4,2};
        int expect_2 = 22;
        AssertUtils.assertEquals(expect_2, solution.minCost(n_2, cuts_2));

        int n_3 = 13;
        int[] cuts_3 = new int[]{3,12,1,5,9,11,4,8,7,2,6,10};
        int expect_3 = 49;
        AssertUtils.assertEquals(expect_3, solution.minCost(n_3, cuts_3));

        int n_4 = 361854;
        int[] cuts_4 = new int[]{189669,19764,186974,266684,308618,191043,93845,63299,301226,240305,193004,263010,96073,46256,158102,339050,126229,84452,194933,156037,108468,280630,331189,68099,113690,226890,72364,61761,27058,45026,312309,254439,45520,352784,146420,184754,4940,337288,139892,245863,121428,129668,235331,169793,303858,17980,82103,173929,153859,346349,212767,34686,292509,277623,229869,179551,109328,277635,90272,161893,231118,234035,197316,55569,145427,331347,273905,99093,897,236085,178546,57071,164600,73468,238137,183884,273592,67280,163749,239833,212549,312876,126574,255182,68843,357516,103654,114507,317125,264970};
        int expect_4 = 2252276;
        AssertUtils.assertEquals(expect_4, solution.minCost(n_4, cuts_4));

    }
}
