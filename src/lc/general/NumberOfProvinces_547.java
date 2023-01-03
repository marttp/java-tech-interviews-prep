package lc.general;

import common.unionfind.UnionFindNumArr;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces_547 {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        UnionFindNumArr uf = new UnionFindNumArr(size);
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                if (isConnected[a][b] == 1) {
                    uf.union(a, b);
                }
            }
        }
        Set<Integer> provinces = new HashSet<>();
        for (int i = 0; i < size; i++) {
            provinces.add(uf.find(i));
        }
        return provinces.size();
    }

}
