package dsalg.two.searching;

public class BinarySearchDuplicate {

    public static void main(String[] args) {
        BinarySearchDuplicate o = new BinarySearchDuplicate();
        int[] A = {1, 3, 5, 7, 7, 8, 8, 8, 10, 10, 10, 10, 10, 14, 15, 17, 20, 21, 22, 22, 23};
        System.out.println(o.binarySearchDuplicate(A, 0, A.length, 10));
        System.out.println(o.binarySearchDuplicateLast(A, 0, A.length, 10));
        System.out.println(o.numOccurence(A, 10));
    }

    int numOccurence(int[] A, int k) {
        return binarySearchDuplicateLast(A, 0, A.length, k) - binarySearchDuplicate(A, 0, A.length, k) + 1;
    }

    int binarySearchDuplicate(int[] A, int l, int r, int k) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;

        if (A[m] == k) {
            if (m == l || A[m] > A[m - 1]) return m;
            return binarySearchDuplicate(A, l, m - 1, k);
        } else if (A[m] < k) {
            return binarySearchDuplicate(A, m + 1, r, k);
        } else {
            return binarySearchDuplicate(A, l, m - 1, k);
        }
    }

    int binarySearchDuplicateLast(int[] A, int l, int r, int k) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;

        if (A[m] == k) {
            if (m == r || A[m] < A[m + 1]) return m;
            return binarySearchDuplicateLast(A, m + 1, r, k);
        } else if (A[m] < k) {
            return binarySearchDuplicateLast(A, m + 1, r, k);
        } else {
            return binarySearchDuplicateLast(A, l, m - 1, k);
        }
    }
}
