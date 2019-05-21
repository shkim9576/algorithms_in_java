package dsalg.two.searching;

public class FindPivot {

    public static void main(String[] args) {
        FindPivot o = new FindPivot();
        int[] A = {8, 10, 12, 13, 15, 20, 27, 1, 3, 4, 5, 7};
        System.out.println(o.findPivot(A, 10));
    }

    int findPivot(int[] A, int k) {
        return findPivot(A, 0, A.length - 1, 4);
    }

    int findPivot(int[] A, int l, int r, int k) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;

        if (A[m] == k) return m;
        else if (A[l] < A[m]) {
            if (A[l] <= k && k < A[m]) return findPivot(A, l, m - 1, k);
            else return findPivot(A, m + 1, r, k);
        } else { // (A[m] < A[r])
            if (A[m] < k && k <= A[r]) return findPivot(A, m + 1, r, k);
            else return findPivot(A, l, m - 1, k);
        }
    }
}
