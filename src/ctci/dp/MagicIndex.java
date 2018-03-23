package ctci.dp;

public class MagicIndex {

    public static void main(String[] args) {
        int[] A = {-3, -1, 0, 3, 6, 10};

        MagicIndex ob = new MagicIndex();
        System.out.println(ob.findMagicIndex(A));
        System.out.println(ob.findMagicIndexRec(A));
    }

    int findMagicIndex(int[] A) {
        if (A == null || A.length == 0) return -1;

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == m) return m;
            if (A[m] > m) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }

    int findMagicIndexRec(int[] A) {
        return findMagicIndexRec(A, 0, A.length - 1);
    }

    int findMagicIndexRec(int[] A, int l, int r) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;
        if (A[m] == m) return m;
        if (A[m] > m) return findMagicIndexRec(A, l, m - 1);
        return findMagicIndexRec(A, m + 1, r);
    }

}
