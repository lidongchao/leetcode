package bitwiseAndOfNumbersRange201;

public class BruceForce {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int ans = m;
        for (int i = m + 1; i <= n; i++) {
            ans &= i;
        }
        return ans;
    }
}
