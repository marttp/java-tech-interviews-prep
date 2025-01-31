package lc.general;

public class MinimumFlipsToMakeAORBEqualToC_1318 {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        // 32 bits => function need int?
        for (int i = 0; i < 32; i++) {
            // Get bit technique
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            if ((bitA | bitB) != bitC) {
                // Since it's OR => if c == 0 and it's false from previous condition
                // bitA, bitB need to flip if they're 1
                // count will add by 1 for set bit
                // otherwise, add nothing
                if (bitC == 0) {
                    count += bitA + bitB;
                } else {
                    // Either flip a or b, required at least one of them
                    count++;
                }
            }
        }
        return count;
    }
}
