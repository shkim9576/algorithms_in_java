package dsalg.one.recursion;

public class CheckArraySorted {
    public static void main(String[] args) {
        CheckArraySorted o = new CheckArraySorted();

        int[] A = {-1, 2, 3, 3, 5, 6, 7, 7, 10};
        System.out.println(o.isSorted(A, A.length - 1));

        int[] B = {-1, 2, 3, 3, 5, 2, 7, 7, 10};
        System.out.println(o.isSorted(B, B.length - 1));
    }

    private boolean isSorted(int[] A, int N) {
        if (N <= 1) {
            return true;
        }

        if (A[N] < A[N - 1]) return false;
        return isSorted(A, N - 1);
    }
}
