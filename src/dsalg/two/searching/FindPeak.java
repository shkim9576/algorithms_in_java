package dsalg.two.searching;

public class FindPeak {

    public static void main(String[] args) {
        FindPeak o = new FindPeak();
        int[] A = {1, 3, 5, 8, 10, 15, 13, 11, 3, 2, 1, -2, -10};
        System.out.println(o.findPeak(A));
    }

    int findPeak(int[] A) {
        if (A == null || A.length == 0) return -1;

        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            if (r - l == 0) return A[r];
            if (r - l == 1) return Math.max(A[r], A[l]);

            int m = l + (r - l) / 2;
            if (A[m] > A[m - 1] && A[m] > A[m + 1]) {
                return A[m];
            } else if (A[m - 1] < A[m] && A[m] < A[m + 1]) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}
