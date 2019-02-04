package ctci.first.sortingsearch;

public class RotatedArray {
    public static void main(String[] args) {
        int[] A = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        RotatedArray ob = new RotatedArray();
        System.out.println(ob.find(A, 5));
    }

    int find(int[] A, int x) {
        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (A[m] == x) return m;
            if (A[0] < A[m]) {
                if (x < A[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (x > A[m]) l = m + 1;
                else r = m - 1;
            }
        }

        return -1;
    }

}
