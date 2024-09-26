public class Main {
    public static void main(String[] args) {
        int[] x = {1, 3, 5, 7, 9};
        int[] y = {2, 4, 6, 8, 10, 12};

        int[] z = merge(x, y);

        System.out.print("Merged Array: ");
        for (int num : z) {
            System.out.print(num + " ");
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < m) {
            c[k++] = a[i++];
        }

        while (j < n) {
            c[k++] = b[j++];
        }

        return c;
    }
}
