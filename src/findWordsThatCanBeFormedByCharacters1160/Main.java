package findWordsThatCanBeFormedByCharacters1160;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String[] words_1 = {"cat","bt","hat","tree"};
        String chars_1 = "atach";
        int expect_1 = 6;  // len(cat) + len(hat) = 6
        AssertUtils.assertEqualsInteger(expect_1, solution.countCharacters(words_1, chars_1));

        String[] words_2 = {"hello","world","leetcode"};
        String chars_2 = "welldonehoneyr";
        int expect_2 = 10;  // len(hello) + len(world) = 10
        AssertUtils.assertEqualsInteger(expect_2, solution.countCharacters(words_2, chars_2));

        String[] words_3 = {"boygirdlggnh"};
        String chars_3 = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        int expect_3 = 0;
        AssertUtils.assertEqualsInteger(expect_3, solution.countCharacters(words_3, chars_3));

    }
}
