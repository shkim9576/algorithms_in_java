package ctci.first.moderate;

public class SubSort {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 8, 10, 11, 7, 12, 6, 7, 16, 18, 19};

        SubSort ob = new SubSort();
        System.out.println(ob.sort(A));
    }

    static class Result {
        int l;
        int r;

        Result(int left, int right) {
            l = left;
            r = right;
        }

        public String toString() {
            return "left: " + l + ", right: " + r;
        }
    }

    Result sort(int[] A) {
        if (A == null || A.length < 2) return null;

        int size = A.length;
        int l = 0;
        int r = size - 1;

        while (l < size - 1 && A[l] < A[l + 1]) l++;
        while (r > 0 && A[r] > A[r - 1]) r--;

        int min = findMin(A, l + 1, r - 1);
        int max = findMax(A, l + 1, r - 1);
        while (l > 0 && A[l] > min) l--;
        while (r < size - 1 && A[r] < max) r++;

        return new Result(l + 1, r - 1);
    }

    int findMin(int[] A, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) min = Math.min(min, A[i]);
        return min;
    }

    int findMax(int[] A, int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) max = Math.max(max, A[i]);
        return max;
    }
}
