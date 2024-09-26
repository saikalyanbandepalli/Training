public class Main {
    public static void main(String[] args) {
        int[][] a = { {2, 4, 6}, {8, 10, 12}, {14, 16, 18} };
        int[][] b = { {1, 3, 5}, {7, 9, 11}, {13, 15, 17} };

        int[][] prod = mult(a, b);
        if (prod != null) {
            print(prod);
        }
    }

    public static int[][] mult(int[][] a, int[][] b) {
        int ra = a.length, ca = a[0].length, cb = b[0].length;
        if (ca != b.length) {
            System.out.println("Incompatible sizes.");
            return null;
        }

        int[][] res = new int[ra][cb];
        for (int i = 0; i < ra; i++) {
            for (int j = 0; j < cb; j++) {
                for (int k = 0; k < ca; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    public static void print(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
