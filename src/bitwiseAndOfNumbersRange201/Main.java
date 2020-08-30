package bitwiseAndOfNumbersRange201;

import utils.AssertUtils;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        AssertUtils.mute();

        Solution solution = new Solution();
        BruceForce bruceForce = new BruceForce();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {

            int m = random.nextInt(10000);
            int n = m + random.nextInt(10000);

            if (!AssertUtils.assertEquals(bruceForce.rangeBitwiseAnd(m, n), solution.rangeBitwiseAnd(m, n))) {
                System.out.println(String.format("m = %d, n = %d", m, n));
            }

        }


    }
}
