package g4g.search.excercise;

public class MedianTwoSorted {
    // https://www.geeksforgeeks.org/median-of-two-sorted-arrays/

    public static void main(String[] args) {
        int[] A = {1, 12, 15, 26, 38};
        int[] B = {2, 13, 17, 30, 45};
        //int[] A = {1, 2, 3};
        //int[] B = {5, 6, 7};

        MedianTwoSorted ob = new MedianTwoSorted();
        System.out.println(ob.getMedian(A, B));
    }

    int getMedian(int[] A, int[] B) {

        if (A == null || B == null) return -1;
        if (A.length != B.length) return -1;

        if (A[A.length - 1] < B[0]) return (A[A.length - 1] + B[0]) / 2;
        if (B[B.length - 1] < A[0]) return (B[B.length - 1] + A[0]) / 2;

        int ai = 0;
        int bi = 0;
        while ((ai + bi) < A.length && ai < A.length && bi < B.length) {
            if (A[ai] < B[bi]) ai++;
            else bi++;
        }

        if (A[ai] > B[bi]) ai--;
        else bi--;

        return (A[ai] + B[bi]) / 2;
    }

}
