package findLatestGroupOfSizeM5497;

import utils.ArrayUtils;
import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
        示例 1：
        输入：arr = [3,5,1,2,4], m = 1
        输出：4
        解释：
        步骤 1："00100"，由 1 构成的组：["1"]
        步骤 2："00101"，由 1 构成的组：["1", "1"]
        步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
        步骤 4："11101"，由 1 构成的组：["111", "1"]
        步骤 5："11111"，由 1 构成的组：["11111"]
        存在长度为 1 的一组 1 的最后步骤是步骤 4 。
         */
        {
            int[] arr = ArrayUtils.stringToPrimitiveIntArray("[3,5,1,2,4]");
            int expect = 4;
            AssertUtils.assertEquals(expect, solution.findLatestStep(arr, 1));
        }

        /*
        示例 2：
        输入：arr = [3,1,5,4,2], m = 2
        输出：-1
        解释：
        步骤 1："00100"，由 1 构成的组：["1"]
        步骤 2："10100"，由 1 构成的组：["1", "1"]
        步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
        步骤 4："10111"，由 1 构成的组：["1", "111"]
        步骤 5："11111"，由 1 构成的组：["11111"]
        不管是哪一步骤都无法形成长度为 2 的一组 1 。
         */
        {
            int[] arr = ArrayUtils.stringToPrimitiveIntArray("[3,1,5,4,2]");
            int expect = -1;
            AssertUtils.assertEquals(expect, solution.findLatestStep(arr, 2));
        }

        {
            int[] arr = ArrayUtils.stringToPrimitiveIntArray("[1]");
            int expect = 1;
            AssertUtils.assertEquals(expect, solution.findLatestStep(arr, 1));
        }

        {
            int[] arr = ArrayUtils.stringToPrimitiveIntArray("[2,1]");
            int expect = 2;
            AssertUtils.assertEquals(expect, solution.findLatestStep(arr, 2));
        }


    }
}
