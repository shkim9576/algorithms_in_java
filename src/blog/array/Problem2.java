package blog.array;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 p = new Problem2();

        int[] A = new int[]{1, 3, 20, 4, 1, 0};
        System.out.println(p.findPeak(A));
    }

    int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }

        return findPeak(A, 0, A.length - 1);
    }

    int findPeak(int[] A, int start, int end) {
        int middle = start + (end - start) / 2;

        if ((middle == 0 || A[middle - 1] <= A[middle]) && (middle == end || A[middle + 1] <= A[middle])) {
            return A[middle];
        } else if (middle > 0 && A[middle - 1] <= A[middle]) {
            return findPeak(A, middle + 1, end);
        }

        return findPeak(A, start, middle - 1);
    }
}
