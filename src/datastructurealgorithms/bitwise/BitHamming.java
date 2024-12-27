package datastructurealgorithms.bitwise;

public class BitHamming {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

    public static int hammingDistance(int n1, int n2) {
        return hammingWeight(n1 ^ n2);
    }
}
