package datastructurealgorithms.bigo;

public class QubicTime {

    public void cubeSum(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    System.out.println(i * i * i + j * j * j + k * k * k);
                }
            }
        }
    }

    public int[][] matrixMultiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;

        int[][] C = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                C[i][j] = 0;

                for (int p = 0; p < n; p++) {
                    C[i][j] += A[i][p] * B[p][j];
                }
            }
        }

        return C;
    }

}
