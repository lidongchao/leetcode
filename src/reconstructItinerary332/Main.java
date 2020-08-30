package reconstructItinerary332;

import utils.ArrayUtils;
import utils.AssertUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        {
            Solution1 solution1 = new Solution1();
            Solution2 solution2 = new Solution2();
            List<List<String>> lists = ArrayUtils.stringTo2DStringList("[[\"MUC\", \"LHR\"], [\"JFK\", \"MUC\"], [\"SFO\", \"SJC\"], [\"LHR\", \"SFO\"]]");
            List<String> expect = ArrayUtils.stringToStringList("[\"JFK\", \"MUC\", \"LHR\", \"SFO\", \"SJC\"]");
            assert lists != null;
            AssertUtils.assertEqualsList(expect, solution1.findItinerary(lists));
            AssertUtils.assertEqualsList(expect, solution2.findItinerary(lists));
        }

        {
            Solution1 solution1 = new Solution1();
            Solution2 solution2 = new Solution2();
            List<List<String>> lists = ArrayUtils.stringTo2DStringList("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]");
            List<String> expect = ArrayUtils.stringToStringList("[\"JFK\",\"ATL\",\"JFK\",\"SFO\",\"ATL\",\"SFO\"]");
            assert lists != null;
            AssertUtils.assertEqualsList(expect, solution1.findItinerary(lists));
            AssertUtils.assertEqualsList(expect, solution2.findItinerary(lists));
        }

        {
            Solution1 solution1 = new Solution1();
            Solution2 solution2 = new Solution2();
            List<List<String>> lists = ArrayUtils.stringTo2DStringList("[[\"MUC\",\"LHR\"],[\"JFK\",\"MUC\"],[\"SFO\",\"SJC\"],[\"MUC\",\"SFO\"],[\"SJC\",\"MUC\"]]");
            List<String> expect = ArrayUtils.stringToStringList("[JFK, MUC, SFO, SJC, MUC, LHR]");
            assert lists != null;
            AssertUtils.assertEqualsList(expect, solution1.findItinerary(lists));
            AssertUtils.assertEqualsList(expect, solution2.findItinerary(lists));
        }

    }
}
