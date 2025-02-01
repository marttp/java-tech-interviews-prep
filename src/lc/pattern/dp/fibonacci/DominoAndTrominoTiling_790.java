package lc.pattern.dp.fibonacci;

public class DominoAndTrominoTiling_790 {

    public int numTilings(int n) {
        int mod = ((int) 1e9) + 7;
        // 0 - State where empty both
        // 1 - Miss bottom
        // 2 - Miss top
        // 3 - Full
        long[] dp = {0, 0, 0, 1};
        for (int i = 1; i <= n; i++) {
            long[] newDp = new long[4];
            // Empty state => came from prev full state
            newDp[0] = dp[3];
            // Miss Bottom => Fullfill with bottom
            newDp[1] = (dp[2] + dp[0]) % mod;
            // Miss top => Fullfill with top
            newDp[2] = (dp[1] + dp[0]) % mod;
            // Full state can come up from any state
            newDp[3] = (dp[0] + dp[1] + dp[2] + dp[3]) % mod;
            dp = newDp;
        }
        return (int) dp[3];
    }

}
