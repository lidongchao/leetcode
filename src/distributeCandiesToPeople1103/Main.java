package distributeCandiesToPeople1103;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution2 solution = new Solution2();

        int candies_1 = 7;
        int num_people_1 = 4;
        int[] expect_1 = {1,2,3,1};
        AssertUtils.assertEqualsArray(expect_1, solution.distributeCandies(candies_1,num_people_1));

        int candies_2 = 10;
        int num_people_2 = 3;
        int[] expect_2 = {5,2,3};
        AssertUtils.assertEqualsArray(expect_2, solution.distributeCandies(candies_2,num_people_2));

        int candies_3 = 60;
        int num_people_3 = 4;
        int[] expect_3 = {15,18,15,12};
        AssertUtils.assertEqualsArray(expect_3, solution.distributeCandies(candies_3,num_people_3));

        int candies_4 = 60;
        int num_people_4 = 5;
        int[] expect_4 = {12,9,11,13,15};
        AssertUtils.assertEqualsArray(expect_4, solution.distributeCandies(candies_4,num_people_4));
    }

}
