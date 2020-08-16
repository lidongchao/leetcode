package kidWithTheGreatestNumberOfCandies1431;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candies_1 = {2,3,5,1,3};
        int extraCandies_1 = 3;
        Boolean[] expect_1 = {true,true,true,false,true};
        AssertUtils.assertEqualsArray(expect_1, solution.kidsWithCandies(candies_1, extraCandies_1).toArray());

        int[] candies_2 = {4,2,1,1,2};
        int extraCandies_2 = 1;
        Boolean[] expect_2 = {true,false,false,false,false};
        AssertUtils.assertEqualsArray(expect_2, solution.kidsWithCandies(candies_2, extraCandies_2).toArray());
    }
}
