package wordLadderII126;

import utils.AssertUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String  beginWord_1 = "hit";
        String    endWord_1 = "cog";
        String[] wordList_1 = {"hot","dot","dog","lot","log","cog"};
        int        expect_1 = 2;

        AssertUtils.assertEquals(expect_1,
                solution.findLadders(beginWord_1,
                                       endWord_1,
                        Arrays.asList(wordList_1)).size());

        String  beginWord_2 = "a";
        String    endWord_2 = "c";
        String[] wordList_2 = {"a","b","c"};
        int        expect_2 = 1;

        AssertUtils.assertEquals(expect_2,
                solution.findLadders(beginWord_2,
                                       endWord_2,
                        Arrays.asList(wordList_2)).size());

    }
}
