package lc.general.medium;

public class NumberOfSubarraysWithOddSum_1524 {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0;
        int evenCount = 1; // Start with 1 for empty subarray (sum = 0 is even)
        int sum = 0;
        int result = 0;

        for (int num : arr) {
            sum += num;
            if (sum % 2 == 1) {
                result = (result + evenCount) % MOD;
                oddCount++;
            } else {
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }

        return result;
    }
}
